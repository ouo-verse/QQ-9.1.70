package com.tencent.qqnt.pluspanel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0001IB\u0017\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00103\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010!\u001a\u00020\u00062\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001ej\b\u0012\u0004\u0012\u00020\u001c`\u001fJ\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0012J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010,\u001a\u00020\u0006R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R&\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001ej\b\u0012\u0004\u0012\u00020\u001c`\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00104R\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u00108R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u00109R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00102R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010*\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00107R\u0016\u0010B\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00107R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/pluspanel/adapter/c;", "Landroidx/viewpager/widget/PagerAdapter;", "", "page", "Landroidx/recyclerview/widget/RecyclerView;", TtmlNode.TAG_LAYOUT, "", "r", "o", "position", "j", "view", "t", "g", "getCount", "Landroid/view/View;", "", "object", "", "isViewFromObject", "obj", "getItemPosition", ParseCommon.CONTAINER, "instantiateItem", "Landroid/view/ViewGroup;", "destroyItem", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/qqnt/pluspanel/data/a;", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "appDataList", DomainData.DOMAIN_NAME, "isRobotAIO", "p", "Landroid/view/View$OnClickListener;", "itemOnclickListener", "l", "Landroid/view/View$OnLongClickListener;", "itemOnLongClickListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isAnonymous", "k", "i", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "e", "I", "mAddedHeight", "Ljava/util/ArrayList;", "appDataLists", h.F, "Z", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnClickListener;", BdhLogUtil.LogTag.Tag_Conn, "columnNum", "D", "rowNum", "E", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "G", "isPanelHeightChange", "Lcom/tencent/mobileqq/emoticonview/PanelRecycleBin;", "H", "Lcom/tencent/mobileqq/emoticonview/PanelRecycleBin;", "mRecycleBin", "<init>", "(Landroid/content/Context;I)V", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends PagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int columnNum;

    /* renamed from: D, reason: from kotlin metadata */
    private int rowNum;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ViewGroup container;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isAnonymous;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isPanelHeightChange;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private PanelRecycleBin mRecycleBin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mAddedHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.qqnt.pluspanel.data.a> appDataLists;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isRobotAIO;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View.OnLongClickListener itemOnLongClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener itemOnclickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/adapter/c$a;", "", "", "LIST_HORIZONTAL_PADDING", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.adapter.c$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/pluspanel/adapter/c$b", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends GridLayoutManager {
        static IPatchRedirector $redirector_;

        b(Context context, int i3) {
            super(context, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull Context mContext, int i3) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, i3);
            return;
        }
        this.mContext = mContext;
        this.mAddedHeight = i3;
        this.appDataLists = new ArrayList<>();
        this.columnNum = 4;
        this.rowNum = 2;
        this.mRecycleBin = new PanelRecycleBin();
    }

    private final int g(RecyclerView layout) {
        if (layout.getTag() instanceof com.tencent.qqnt.pluspanel.data.d) {
            Object tag = layout.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.data.PageData");
            return ((com.tencent.qqnt.pluspanel.data.d) tag).b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RecyclerView recyclerView, View container, c this$0) {
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        recyclerView.addItemDecoration(new e(container, this$0.isRobotAIO));
    }

    private final void j(int position) {
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            Intrinsics.checkNotNull(viewGroup);
            View childAt = viewGroup.getChildAt(position);
            if (childAt != null) {
                childAt.setTag(Integer.valueOf(position));
            }
        }
    }

    private final void o(RecyclerView layout, int page) {
        if (layout.getTag() instanceof com.tencent.qqnt.pluspanel.data.d) {
            Object tag = layout.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.data.PageData");
            layout.setTag(new com.tencent.qqnt.pluspanel.data.d(page, ((com.tencent.qqnt.pluspanel.data.d) tag).a()));
            return;
        }
        layout.setTag(new com.tencent.qqnt.pluspanel.data.d(page, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, androidx.recyclerview.widget.RecyclerView$Adapter, java.lang.Object] */
    private final void r(int page, RecyclerView layout) {
        Integer num;
        Integer num2;
        int dpToPx = ViewUtils.dpToPx(32.0f);
        layout.setPadding(dpToPx, 0, dpToPx, 0);
        o(layout, page);
        final List<com.tencent.qqnt.pluspanel.data.a> f16 = f(page);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (layout.getAdapter() != null) {
            ?? adapter = layout.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<com.tencent.qqnt.pluspanel.adapter.ViewHolder>");
            objectRef.element = adapter;
        }
        View.OnLongClickListener onLongClickListener = null;
        Integer num3 = null;
        if (QLog.isColorLevel()) {
            if (f16 != null) {
                num2 = Integer.valueOf(f16.size());
            } else {
                num2 = null;
            }
            QLog.d("PanelAdapter", 2, "updateRecyclerView page = " + page + ", dataList = " + num2);
        }
        T t16 = objectRef.element;
        if (t16 instanceof d) {
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.adapter.PlusPanelAppListAdapter");
            final d dVar = (d) t16;
            dVar.p0(f16);
            dVar.q0(this.isRobotAIO);
            RecyclerView.ItemAnimator itemAnimator = layout.getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.setChangeDuration(0L);
            }
            try {
                if (QLog.isColorLevel()) {
                    d dVar2 = (d) objectRef.element;
                    if (dVar2 != null) {
                        num3 = Integer.valueOf(dVar2.getNUM_BACKGOURND_ICON());
                    }
                    QLog.d("PanelAdapter", 2, "updateRecyclerView PlusPanelAppListAdapter page = " + page + ", adapter.itemCount = " + num3);
                }
                layout.post(new Runnable() { // from class: com.tencent.qqnt.pluspanel.adapter.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.s(d.this, objectRef, f16);
                    }
                });
                return;
            } catch (Exception e16) {
                QLog.e("PanelAdapter", 1, e16.getMessage());
                return;
            }
        }
        if (QLog.isColorLevel()) {
            RecyclerView.Adapter adapter2 = (RecyclerView.Adapter) objectRef.element;
            if (adapter2 != null) {
                num = Integer.valueOf(adapter2.getNUM_BACKGOURND_ICON());
            } else {
                num = null;
            }
            QLog.d("PanelAdapter", 2, "updateRecyclerView PlusPanelAppListAdapter page = " + page + ", adapter.itemCount = " + num);
        }
        View.OnClickListener onClickListener = this.itemOnclickListener;
        if (onClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemOnclickListener");
            onClickListener = null;
        }
        View.OnLongClickListener onLongClickListener2 = this.itemOnLongClickListener;
        if (onLongClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemOnLongClickListener");
        } else {
            onLongClickListener = onLongClickListener2;
        }
        d dVar3 = new d(onClickListener, onLongClickListener, "em_group_plus_application");
        dVar3.p0(f16);
        dVar3.q0(this.isRobotAIO);
        layout.setAdapter(dVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(d pluginAdapter, Ref.ObjectRef adapter, List dataList) {
        Intrinsics.checkNotNullParameter(pluginAdapter, "$pluginAdapter");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        pluginAdapter.notifyItemRangeChanged(0, Math.max(((d) adapter.element).getNUM_BACKGOURND_ICON(), dataList.size()));
    }

    private final void t(RecyclerView view) {
        if (view.getTag() instanceof com.tencent.qqnt.pluspanel.data.d) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.data.PageData");
            view.setTag(new com.tencent.qqnt.pluspanel.data.d(((com.tencent.qqnt.pluspanel.data.d) tag).b(), this.mAddedHeight));
            return;
        }
        view.setTag(new com.tencent.qqnt.pluspanel.data.d(0, this.mAddedHeight));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, container, Integer.valueOf(position), obj);
            return;
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        container.removeView((View) obj);
    }

    @NotNull
    public final List<com.tencent.qqnt.pluspanel.data.a> f(int page) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, page);
        }
        int i3 = this.columnNum * this.rowNum;
        int i16 = page * i3;
        ArrayList<com.tencent.qqnt.pluspanel.data.a> arrayList = this.appDataLists;
        if (arrayList != null && arrayList.size() > 0 && i16 >= 0 && i16 < this.appDataLists.size()) {
            List<com.tencent.qqnt.pluspanel.data.a> subList = this.appDataLists.subList(i16, Math.min(this.appDataLists.size(), i3 + i16));
            Intrinsics.checkNotNullExpressionValue(subList, "appDataLists.subList(startIndex, endIndex)");
            return subList;
        }
        return new ArrayList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        ArrayList<com.tencent.qqnt.pluspanel.data.a> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (this.columnNum != 0 && this.rowNum != 0 && (arrayList = this.appDataLists) != null) {
            int size = arrayList.size();
            return ((size + (r1 * r2)) - 1) / (this.columnNum * this.rowNum);
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, obj)).intValue();
        }
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (this.isAnonymous) {
            QLog.d("PanelAdapter", 2, "is about anonymity");
            return -2;
        }
        if ((obj instanceof RecyclerView) && g((RecyclerView) obj) >= getF373114d()) {
            return -2;
        }
        if (this.isPanelHeightChange) {
            QLog.i("PanelAdapter", 2, "is about panel height");
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.isPanelHeightChange = true;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull final View container, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) container, position);
        }
        Intrinsics.checkNotNullParameter(container, "container");
        if (QLog.isColorLevel()) {
            QLog.d("PanelAdapter", 2, "instantiateItem position = " + position + ", isPanelHeightChange = " + this.isPanelHeightChange);
        }
        this.isPanelHeightChange = false;
        this.container = (ViewGroup) container;
        View a16 = new com.tencent.qqnt.plus_panel_impl.x2k.b(this.mContext, null, 2, null).a();
        Intrinsics.checkNotNull(a16);
        View findViewById = a16.findViewById(R.id.f26070cj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.plus_panel_rv)");
        final RecyclerView recyclerView = (RecyclerView) findViewById;
        t(recyclerView);
        recyclerView.setOverScrollMode(2);
        recyclerView.setLayoutManager(new b(this.mContext, this.columnNum));
        container.post(new Runnable() { // from class: com.tencent.qqnt.pluspanel.adapter.a
            @Override // java.lang.Runnable
            public final void run() {
                c.h(RecyclerView.this, container, this);
            }
        });
        r(position, recyclerView);
        if (!Intrinsics.areEqual(a16.getParent(), container) && position < getF373114d()) {
            ((ViewGroup) container).addView(a16);
            j(position);
        }
        return a16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, object)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }

    public final void k(boolean isAnonymous) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isAnonymous);
        } else {
            this.isAnonymous = isAnonymous;
        }
    }

    public final void l(@NotNull View.OnClickListener itemOnclickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) itemOnclickListener);
        } else {
            Intrinsics.checkNotNullParameter(itemOnclickListener, "itemOnclickListener");
            this.itemOnclickListener = itemOnclickListener;
        }
    }

    public final void m(@NotNull View.OnLongClickListener itemOnLongClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) itemOnLongClickListener);
        } else {
            Intrinsics.checkNotNullParameter(itemOnLongClickListener, "itemOnLongClickListener");
            this.itemOnLongClickListener = itemOnLongClickListener;
        }
    }

    public final void n(@NotNull ArrayList<com.tencent.qqnt.pluspanel.data.a> appDataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appDataList);
        } else {
            Intrinsics.checkNotNullParameter(appDataList, "appDataList");
            this.appDataLists = appDataList;
        }
    }

    public final void p(boolean isRobotAIO) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isRobotAIO);
        } else {
            this.isRobotAIO = isRobotAIO;
        }
    }

    public final void q(int page) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, page);
            return;
        }
        if (this.container != null && page >= 0) {
            if (QLog.isColorLevel()) {
                ViewGroup viewGroup = this.container;
                if (viewGroup != null) {
                    num = Integer.valueOf(viewGroup.getChildCount());
                } else {
                    num = null;
                }
                QLog.d("PanelAdapter", 2, "update page = " + page + ", container!!.childCount = " + num);
            }
            ViewGroup viewGroup2 = this.container;
            Intrinsics.checkNotNull(viewGroup2);
            int childCount = viewGroup2.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewGroup viewGroup3 = this.container;
                Intrinsics.checkNotNull(viewGroup3);
                RecyclerView recyclerView = (RecyclerView) viewGroup3.getChildAt(i3).findViewById(R.id.f26070cj);
                if (recyclerView != null && page == g(recyclerView)) {
                    r(page, recyclerView);
                    return;
                }
            }
        }
    }
}
