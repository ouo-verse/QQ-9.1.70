package com.tencent.sqshow.zootopia.nativeui.view.customerface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import g94.FaceResetInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s94.FaceControlPointData;
import sc4.a;
import uv4.am;
import uv4.ax;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u001dB\u0017\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020$\u00a2\u0006\u0004\b;\u0010<J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0006\u0010\u001e\u001a\u00020\bR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010)R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00020*j\b\u0012\u0004\u0012\u00020\u0002`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0005088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/g;", "Lsc4/a;", "Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/g$b;", "", "currentPosition", "", "shouldNotify", "doReport", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "", "from", "l", "Luv4/am;", tl.h.F, "", "Luv4/ax;", "dataList", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k", "a", "Lsc4/a$a;", "holder", "position", "c", "b", "g", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "holderList", "Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", "e", "Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", "faceController", "f", "Luv4/ax;", "currentEditorCfg", "Z", "isFaceSide", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "sideObserver", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends sc4.a<b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<ax> dataList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<b> holderList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.ue.t faceController;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ax currentEditorCfg;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isFaceSide;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Observer<Boolean> sideObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0010R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/g$b;", "Lsc4/a$a;", "", "d", "", "", "", "c", "Luv4/ax;", "cfg", "", "position", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "b", "currentPos", "", "doReport", "e", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "getItemIv", "()Lcom/tencent/image/URLImageView;", "itemIv", "Luv4/ax;", "getCfg", "()Luv4/ax;", "setCfg", "(Luv4/ax;)V", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "I", "getPosition", "()I", "setPosition", "(I)V", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends a.AbstractC11222a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final URLImageView itemIv;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private ax cfg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private com.tencent.sqshow.zootopia.nativeui.data.j channel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            View findViewById = item.findViewById(R.id.pti);
            Intrinsics.checkNotNullExpressionValue(findViewById, "item.findViewById(R.id.face_item)");
            this.itemIv = (URLImageView) findViewById;
        }

        private final void d() {
            y94.a reporter;
            ZplanViewReportHelper mReporter;
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.channel;
            if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
                return;
            }
            mReporter.g(getItemView(), "em_zplan_tab_btn", (r16 & 4) != 0 ? null : c(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }

        public final void b(ax cfg, int position, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
            Intrinsics.checkNotNullParameter(cfg, "cfg");
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.cfg = cfg;
            this.position = position;
            this.channel = channel;
            d();
        }

        private final Map<String, Object> c() {
            Object obj;
            Map<String, Object> mutableMapOf;
            Pair[] pairArr = new Pair[2];
            ax axVar = this.cfg;
            if (axVar == null) {
                obj = "";
            } else {
                obj = Integer.valueOf(axVar.f440258a);
            }
            pairArr[0] = TuplesKt.to("zplan_tab_id", obj);
            ax axVar2 = this.cfg;
            String str = axVar2 != null ? axVar2.f440259b : null;
            pairArr[1] = TuplesKt.to("zplan_tab_name", str != null ? str : "");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return mutableMapOf;
        }

        public final void e(int currentPos, boolean doReport) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar;
            y94.a reporter;
            ZplanViewReportHelper mReporter;
            ax axVar = this.cfg;
            if (axVar == null) {
                return;
            }
            if (currentPos == this.position) {
                if (doReport && (jVar = this.channel) != null && (reporter = jVar.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
                    mReporter.e(getItemView(), "em_zplan_tab_btn", c());
                }
                URLImageView uRLImageView = this.itemIv;
                ax axVar2 = this.cfg;
                Intrinsics.checkNotNull(axVar2);
                String str = axVar2.f440261d;
                Intrinsics.checkNotNullExpressionValue(str, "cfg!!.activeIcon");
                CommonExKt.w(uRLImageView, str, null, null, 6, null);
                return;
            }
            URLImageView uRLImageView2 = this.itemIv;
            Intrinsics.checkNotNull(axVar);
            String str2 = axVar.f440260c;
            Intrinsics.checkNotNullExpressionValue(str2, "cfg!!.icon");
            CommonExKt.w(uRLImageView2, str2, null, null, 6, null);
        }
    }

    public g(Context context, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.context = context;
        this.channel = channel;
        this.dataList = new ArrayList();
        this.holderList = new ArrayList<>();
        this.faceController = channel.getAvatarFaceController();
        this.sideObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.o(g.this, (Boolean) obj);
            }
        };
        i();
    }

    private final am h() {
        int i3;
        Integer num;
        if (this.isFaceSide) {
            ax axVar = this.currentEditorCfg;
            if (axVar != null) {
                i3 = axVar.f440263f;
                num = Integer.valueOf(i3);
            }
            num = null;
        } else {
            ax axVar2 = this.currentEditorCfg;
            if (axVar2 != null) {
                i3 = axVar2.f440262e;
                num = Integer.valueOf(i3);
            }
            num = null;
        }
        return j94.a.f409675a.b(new CameraKey(num != null ? num.intValue() : 0, 0, 2, null));
    }

    private final void i() {
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        g94.e.f401573a.b().observe(lifecycleOwner, this.sideObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(g this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isFaceSide = false;
        g94.e.f401573a.d(new FaceResetInfo(false, "click"));
        n(this$0, i3, true, false, 4, null);
        this$0.l("itemClick");
    }

    private final void l(String from) {
        am h16 = h();
        QLog.i("ZPlanMakeFaceAverageAdapter", 1, "reformUEUpdate from:" + from + ", cameraCfg:" + h16);
        if (this.currentEditorCfg != null && h16 != null) {
            ax axVar = this.currentEditorCfg;
            Intrinsics.checkNotNull(axVar);
            FaceControlPointData faceControlPointData = new FaceControlPointData(axVar.f440258a, this.isFaceSide, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex(), h16);
            com.tencent.sqshow.zootopia.nativeui.ue.t tVar = this.faceController;
            if (tVar != null) {
                tVar.j(faceControlPointData, this.channel);
                return;
            }
            return;
        }
        QLog.e("ZPlanMakeFaceAverageAdapter", 1, "config is null, return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(g this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.isFaceSide = it.booleanValue();
        this$0.l("observeFaceSide");
    }

    @Override // sc4.a
    public int a() {
        return this.dataList.size();
    }

    @Override // sc4.a
    public int b(int position) {
        return 0;
    }

    @Override // sc4.a
    public void c(a.AbstractC11222a holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ((b) holder).b(this.dataList.get(position), position, this.channel);
        this.holderList.add(holder);
        m(0, position == 0, false);
        aa.b(holder.getItemView(), com.tencent.sqshow.zootopia.utils.i.b(5));
        aa.d(holder.getItemView(), new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.j(g.this, position, view);
            }
        });
    }

    public final void g() {
        g94.e.f401573a.b().removeObserver(this.sideObserver);
    }

    @Override // sc4.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b d(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.d_0, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026item_view, parent, false)");
        return new b(inflate);
    }

    public final void p(List<ax> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.holderList.clear();
        this.dataList = dataList;
        setChanged();
        notifyObservers();
    }

    private final void m(int currentPosition, boolean shouldNotify, boolean doReport) {
        if (shouldNotify) {
            ax axVar = this.dataList.get(currentPosition);
            this.currentEditorCfg = axVar;
            g94.e.f401573a.f(axVar != null ? axVar.f440258a : 0);
        }
        Iterator<T> it = this.holderList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).e(currentPosition, doReport);
        }
    }

    static /* synthetic */ void n(g gVar, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        if ((i16 & 4) != 0) {
            z17 = true;
        }
        gVar.m(i3, z16, z17);
    }
}
