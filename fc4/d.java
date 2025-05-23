package fc4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.utils.ae;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.state.data.SquareJSConst;
import fc4.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.f;
import tl.h;
import xv4.ab;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00072\u00020\u0001:\u0003$)'B\u0017\u0012\u0006\u0010.\u001a\u00020*\u0012\u0006\u00103\u001a\u00020/\u00a2\u0006\u0004\b?\u0010@J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J,\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002JI\u0010\u001d\u001a\u00020\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\u001a\u0010'\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0016\u0010(\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0003J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0016R\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b$\u0010+\u001a\u0004\b,\u0010-R\u0017\u00103\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b)\u00100\u001a\u0004\b1\u00102R*\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00104R\u001e\u00109\u001a\n 7*\u0004\u0018\u000106068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00108R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010=\u00a8\u0006A"}, d2 = {"Lfc4/d;", "Lfc4/e;", "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/data/b;", "Lkotlin/collections/ArrayList;", "list", "", h.F, "Landroid/widget/TextView;", "view", "", "text", "", "isVisible", "", "o", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "i", "Landroid/view/View;", "progressBar", "p", "", "Lxv4/ab;", "shineMaterialList", "maxCnt", "currentCnt", DomainData.DOMAIN_NAME, "(Ljava/util/ArrayList;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lfc4/e$a;", "d", "a", "holder", "position", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "getReportHelper", "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Ljava/util/ArrayList;", "dataList", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "e", "Ljava/util/List;", "f", "I", "g", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends e {

    /* renamed from: i, reason: collision with root package name */
    private static final int f398288i = R.drawable.iib;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Object> dataList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Drawable errorDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<ab> shineMaterialList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentCnt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int maxCnt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lfc4/d$a;", "Lfc4/e$a;", "Landroid/widget/ProgressBar;", "b", "Landroid/widget/ProgressBar;", "()Landroid/widget/ProgressBar;", "progressBar", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends e.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ProgressBar progressBar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            View findViewById = item.findViewById(R.id.f163480qc3);
            Intrinsics.checkNotNullExpressionValue(findViewById, "item.findViewById(R.id.pb3)");
            this.progressBar = (ProgressBar) findViewById;
        }

        /* renamed from: b, reason: from getter */
        public final ProgressBar getProgressBar() {
            return this.progressBar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lfc4/d$c;", "Lfc4/e$a;", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", SquareJSConst.Params.PARAMS_NUMS, "c", "e", "time", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "taskIcon", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "taskIconBg", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends e.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final TextView nums;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final TextView time;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ImageView taskIcon;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final ZPlanMediaView taskIconBg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            View findViewById = item.findViewById(R.id.q_m);
            Intrinsics.checkNotNullExpressionValue(findViewById, "item.findViewById(R.id.nums)");
            this.nums = (TextView) findViewById;
            View findViewById2 = item.findViewById(R.id.qqx);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "item.findViewById(R.id.time)");
            this.time = (TextView) findViewById2;
            View findViewById3 = item.findViewById(R.id.qpv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "item.findViewById(R.id.task_icon)");
            this.taskIcon = (ImageView) findViewById3;
            View findViewById4 = item.findViewById(R.id.qpw);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "item.findViewById(R.id.task_icon_bg)");
            this.taskIconBg = (ZPlanMediaView) findViewById4;
        }

        /* renamed from: b, reason: from getter */
        public final TextView getNums() {
            return this.nums;
        }

        /* renamed from: c, reason: from getter */
        public final ImageView getTaskIcon() {
            return this.taskIcon;
        }

        /* renamed from: d, reason: from getter */
        public final ZPlanMediaView getTaskIconBg() {
            return this.taskIconBg;
        }

        /* renamed from: e, reason: from getter */
        public final TextView getTime() {
            return this.time;
        }
    }

    public d(Context context, ZplanViewReportHelper reportHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        this.context = context;
        this.reportHelper = reportHelper;
        this.dataList = new ArrayList<>();
        this.errorDrawable = context.getResources().getDrawable(f398288i);
    }

    private final HashMap<String, Object> i(com.tencent.sqshow.zootopia.data.b data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_award_id", Long.valueOf(data.b().isEmpty() ^ true ? data.b().get(0).getRewardItemId() : -1L));
        hashMap.put("zplan_award_status", Integer.valueOf(data.getRewardStatus()));
        if (this.dataList != null) {
            hashMap.put("zplan_active_level", Integer.valueOf(data.getRewardIndex()));
            hashMap.put("zplan_active_level_coin", Integer.valueOf(r1.size() - 1));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, e.a aVar, com.tencent.sqshow.zootopia.data.b itemData, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        c cVar = (c) aVar;
        this$0.m(cVar.getItemView(), itemData);
        if (str != null) {
            bc4.c.f28271a.d(this$0.context, cVar.getTaskIcon(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0, e.a aVar, com.tencent.sqshow.zootopia.data.b itemData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        this$0.m(((c) aVar).getItemView(), itemData);
        bc4.c.f28271a.b(this$0.context, itemData.b(), 0, itemData.getRewardIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0, e.a aVar, com.tencent.sqshow.zootopia.data.b itemData, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        c cVar = (c) aVar;
        this$0.m(cVar.getItemView(), itemData);
        if (str != null) {
            bc4.c.f28271a.d(this$0.context, cVar.getTaskIcon(), str);
        }
    }

    private final void o(TextView view, String text, boolean isVisible) {
        view.setText(text);
        view.setVisibility(isVisible ? 0 : 4);
    }

    private final void p(View progressBar) {
        ViewGroup.LayoutParams layoutParams = progressBar.getLayoutParams();
        layoutParams.width = (int) (ScreenUtils.getScreenWidth(this.context) * 0.512f);
        progressBar.setLayoutParams(layoutParams);
    }

    @Override // fc4.e
    public int a() {
        ArrayList<Object> arrayList = this.dataList;
        Intrinsics.checkNotNull(arrayList);
        return arrayList.size();
    }

    @Override // fc4.e
    public int b(int position) {
        if (position == 0) {
            return 1;
        }
        return 2;
    }

    @Override // fc4.e
    public e.a d(ViewGroup parent, int viewType) {
        e.a aVar;
        e.a aVar2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.dgt, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026_bar_view, parent, false)");
            aVar = new a(inflate);
        } else if (viewType == 2) {
            View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.dgu, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(context).inflate(R.\u2026item_view, parent, false)");
            aVar = new c(inflate2);
        } else {
            aVar2 = null;
            Intrinsics.checkNotNull(aVar2);
            return aVar2;
        }
        aVar2 = aVar;
        Intrinsics.checkNotNull(aVar2);
        return aVar2;
    }

    public final void m(View view, com.tencent.sqshow.zootopia.data.b data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        this.reportHelper.e(view, "em_zplan_award_give_btn", i(data));
    }

    public final void n(ArrayList<com.tencent.sqshow.zootopia.data.b> data, List<ab> shineMaterialList, Integer maxCnt, Integer currentCnt) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.shineMaterialList = shineMaterialList;
        this.currentCnt = currentCnt != null ? currentCnt.intValue() : 0;
        this.maxCnt = maxCnt != null ? maxCnt.intValue() : 0;
        ArrayList<Object> arrayList = this.dataList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<Object> arrayList2 = this.dataList;
        if (arrayList2 != null) {
            arrayList2.add(Integer.valueOf(h(data)));
        }
        ArrayList<Object> arrayList3 = this.dataList;
        if (arrayList3 != null) {
            arrayList3.addAll(data);
        }
        setChanged();
        notifyObservers();
    }

    private final int h(ArrayList<com.tencent.sqshow.zootopia.data.b> list) {
        int i3;
        Integer valueOf;
        int i16 = 0;
        if ((list == null || list.isEmpty()) || (i3 = this.maxCnt) == 0) {
            return 3;
        }
        if (this.currentCnt >= i3) {
            return 100;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i17 = 0; i17 < size; i17++) {
            arrayList.add(Integer.valueOf(list.get(i17).getQuestAmount()));
        }
        int i18 = 0;
        while (true) {
            if (i18 >= size) {
                break;
            }
            Object obj = arrayList.get(i18);
            Intrinsics.checkNotNullExpressionValue(obj, "progressList[index]");
            if (((Number) obj).intValue() >= this.currentCnt) {
                i16 = i18;
                break;
            }
            i18++;
        }
        Object obj2 = arrayList.get(i16);
        if (i16 <= 0) {
            valueOf = (Integer) obj2;
        } else {
            int intValue = ((Number) obj2).intValue();
            Object obj3 = arrayList.get(i16 - 1);
            Intrinsics.checkNotNullExpressionValue(obj3, "progressList[firstBigIndex - 1]");
            valueOf = Integer.valueOf(intValue - ((Number) obj3).intValue());
        }
        Intrinsics.checkNotNullExpressionValue(valueOf, "if(firstBigIndex <= 0) p\u2026ssList[firstBigIndex - 1]");
        int intValue2 = (int) ((((i16 + 1) - ((((Number) arrayList.get(i16)).intValue() - this.currentCnt) / valueOf.intValue())) / size) * 100);
        QLog.d("CustomerProgressIconAdapter", 1, "calculateProgress progress:" + intValue2);
        return intValue2;
    }

    @Override // fc4.e
    public void c(final e.a holder, int position) {
        ArrayList<Object> arrayList = this.dataList;
        Object obj = arrayList != null ? arrayList.get(position) : null;
        boolean z16 = true;
        if (obj == null) {
            QLog.d("CustomerProgressIconAdapter", 1, "position" + position + " data is null, return");
            return;
        }
        QLog.d("CustomerProgressIconAdapter", 1, "onBindViewHolder, position" + position + ", data" + obj);
        int b16 = b(position);
        if (b16 == 1) {
            int intValue = ((Integer) obj).intValue();
            Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.taskcenter.header.progress.CustomerProgressIconAdapter.BarViewHolder");
            ProgressBar progressBar = ((a) holder).getProgressBar();
            p(progressBar);
            progressBar.setProgress(intValue);
            return;
        }
        if (b16 != 2) {
            return;
        }
        Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.taskcenter.header.progress.CustomerProgressIconAdapter.ItemViewHolder");
        c cVar = (c) holder;
        final com.tencent.sqshow.zootopia.data.b bVar = (com.tencent.sqshow.zootopia.data.b) obj;
        ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = bVar.b().get(0);
        this.reportHelper.g(cVar.getItemView(), "em_zplan_award_give_btn", (r16 & 4) != 0 ? null : i(bVar), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ae.INSTANCE.a(cVar.getTaskIcon(), bVar.getStatusIcon(), this.errorDrawable, f398288i);
        final String itemTitle = zootopiaTaskRewardInfo.getItemTitle();
        int rewardStatus = bVar.getRewardStatus();
        if (rewardStatus == 0 || rewardStatus == 1 || rewardStatus == 2) {
            cVar.getTime().setText(this.context.getResources().getString(R.string.xvq, String.valueOf(bVar.getQuestAmount())));
            cVar.getTime().setTextColor(this.context.getResources().getColor(R.color.f8707o));
            o(cVar.getNums(), String.valueOf(zootopiaTaskRewardInfo.getRewardItemCnt()), true);
            cVar.getTaskIconBg().setVisibility(8);
            cVar.getItemView().setOnClickListener(new View.OnClickListener() { // from class: fc4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.j(d.this, holder, bVar, itemTitle, view);
                }
            });
            return;
        }
        if (rewardStatus != 3) {
            if (rewardStatus != 4) {
                return;
            }
            cVar.getTime().setText(this.context.getResources().getString(R.string.xvr));
            o(cVar.getNums(), String.valueOf(zootopiaTaskRewardInfo.getRewardItemCnt()), false);
            cVar.getTime().setTextColor(this.context.getResources().getColor(R.color.f8697n));
            cVar.getTaskIconBg().setVisibility(8);
            cVar.getItemView().setOnClickListener(new View.OnClickListener() { // from class: fc4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.l(d.this, holder, bVar, itemTitle, view);
                }
            });
            return;
        }
        cVar.getTime().setText(this.context.getResources().getString(R.string.xvp));
        o(cVar.getNums(), String.valueOf(zootopiaTaskRewardInfo.getRewardItemCnt()), true);
        cVar.getTime().setTextColor(this.context.getResources().getColor(R.color.f8677l));
        cVar.getTaskIconBg().setVisibility(0);
        cVar.getItemView().setOnClickListener(new View.OnClickListener() { // from class: fc4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.k(d.this, holder, bVar, view);
            }
        });
        List<ab> list = this.shineMaterialList;
        if (list != null) {
            List<ab> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            f.f435541a.h(cVar.getTaskIconBg(), list.get(0));
        }
    }
}
