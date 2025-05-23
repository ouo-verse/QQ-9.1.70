package com.tencent.mobileqq.qwallet.home.tips;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u001bB\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\u001a\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R&\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(R&\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\t0$j\b\u0012\u0004\u0012\u00020\t`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R&\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010&R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010/R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00103R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/g;", "", "", "e", "", "Lcom/qwallet/data/d;", "src", "f", "tips", "", "hideType", "k", "l", "", "actionName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", DomainData.DOMAIN_NAME, "j", "Landroid/content/Context;", "context", "Landroid/view/View;", "g", "tenpayBelt", "d", "beltList", "c", "a", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsLayout;", "b", "Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsLayout;", "mTopTipsLayout", "I", "mBlueTipsHeight", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mWaitList", "Lcom/qwallet/data/d;", "currentBelt", "mBlueTipsRecords", "homeBelts", tl.h.F, "", "i", "Z", "isGetTenpayInfo", "isGetHomeRsp", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "mCloseListener", "mTipsClickListener", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsLayout;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TopTipsLayout mTopTipsLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int mBlueTipsHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.qwallet.data.d> mWaitList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.qwallet.data.d currentBelt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Integer> mBlueTipsRecords;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.qwallet.data.d> homeBelts;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.qwallet.data.d tenpayBelt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isGetTenpayInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isGetHomeRsp;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener mCloseListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener mTipsClickListener;

    public g(@Nullable Context context, @NotNull TopTipsLayout mTopTipsLayout) {
        Intrinsics.checkNotNullParameter(mTopTipsLayout, "mTopTipsLayout");
        this.mContext = context;
        this.mTopTipsLayout = mTopTipsLayout;
        this.mBlueTipsHeight = ViewUtils.dip2px(48.0f);
        this.mWaitList = new ArrayList<>();
        this.mBlueTipsRecords = a.f278148a.b();
        this.homeBelts = new ArrayList<>();
        this.mCloseListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.home.tips.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.h(g.this, view);
            }
        };
        this.mTipsClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.home.tips.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.i(g.this, view);
            }
        };
    }

    private final void e() {
        ArrayList arrayList = new ArrayList();
        com.qwallet.data.d dVar = this.tenpayBelt;
        if (dVar != null) {
            arrayList.add(dVar);
        }
        arrayList.addAll(this.homeBelts);
        if (this.mContext == null) {
            return;
        }
        List<com.qwallet.data.d> f16 = f(arrayList);
        this.mWaitList.clear();
        this.mWaitList.addAll(f16);
        o();
    }

    private final List<com.qwallet.data.d> f(List<com.qwallet.data.d> src) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (Object obj : src) {
            com.qwallet.data.d dVar = (com.qwallet.data.d) obj;
            boolean z17 = true;
            if (dVar.getType() != 4) {
                if (QWalletUtils.o(dVar.getDateRange())) {
                    ArrayList<Integer> arrayList2 = this.mBlueTipsRecords;
                    if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                        Iterator<T> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            if (((Number) it.next()).intValue() == dVar.getId()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                            }
                        }
                    }
                }
                z17 = false;
                break;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final View g(Context context, com.qwallet.data.d tips) {
        if (context == null) {
            return null;
        }
        View inflate = View.inflate(context, R.layout.hjc, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f164597t64);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f164596t63);
        TextView textView = (TextView) inflate.findViewById(R.id.t65);
        ol2.b.f(textView, 20, false, 4, null);
        textView.setText(tips.getName());
        if (tips.getType() == 2) {
            imageView2.setVisibility(8);
            imageView.setVisibility(0);
            imageView.setOnClickListener(this.mCloseListener);
        } else {
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
        }
        inflate.setOnClickListener(this.mTipsClickListener);
        QWalletUtils.x(inflate, tips.getName());
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(this$0.currentBelt, 1);
        this$0.n(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(g this$0, View view) {
        String str;
        boolean z16;
        boolean gotoFakeUrl;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qwallet.data.d dVar = this$0.currentBelt;
        if (dVar != null) {
            str = dVar.getUrl();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String c16 = com.tencent.mobileqq.base.a.c();
            if (FakeUrlUtils.isUseNewFakeUrl()) {
                gotoFakeUrl = new QWalletFakeUrlHandler(this$0.mContext, c16).dispatch(str);
            } else {
                gotoFakeUrl = new QWalletFakeUrl(this$0.mContext, c16).gotoFakeUrl(str);
            }
            if (!gotoFakeUrl) {
                com.tencent.mobileqq.qwallet.utils.k.h(this$0.mContext, str);
            }
            com.tencent.mobileqq.qwallet.c.f("qpayindex.yellowtips.click", null, "1", null, null, 26, null);
        }
        this$0.k(this$0.currentBelt, 0);
        this$0.n(0);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(int hideType) {
        if (hideType == 0) {
            return;
        }
        o();
    }

    private final void k(com.qwallet.data.d tips, int hideType) {
        String str;
        if (tips == null) {
            return;
        }
        if (tips.getType() != 4) {
            this.mBlueTipsRecords.add(Integer.valueOf(tips.getId()));
            a.f278148a.c(this.mBlueTipsRecords);
        }
        if (hideType == 1) {
            str = "index.risk_bar.close";
        } else {
            str = "index.risk_bar.click";
        }
        m(str, tips);
    }

    private final void l(com.qwallet.data.d tips) {
        this.currentBelt = tips;
        m("index.risk_bar.show", tips);
    }

    private final void m(String actionName, com.qwallet.data.d tips) {
        String str;
        String valueOf = String.valueOf(tips.getId());
        int type = tips.getType();
        if (type != 0) {
            if (type != 2) {
                if (type != 4) {
                    str = "";
                } else {
                    str = "2";
                }
            } else {
                str = "5";
            }
        } else {
            str = "4";
        }
        com.tencent.mobileqq.qwallet.c.f(actionName, valueOf, str, null, null, 24, null);
        QWalletUtils.s(actionName, "", valueOf, str, "");
    }

    private final void n(int hideType) {
        this.mTopTipsLayout.removeAllViews();
        j(hideType);
    }

    private final void o() {
        Object removeFirstOrNull;
        this.mTopTipsLayout.removeAllViews();
        removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(this.mWaitList);
        com.qwallet.data.d dVar = (com.qwallet.data.d) removeFirstOrNull;
        if (dVar == null) {
            return;
        }
        View g16 = g(this.mContext, dVar);
        if (g16 != null) {
            l(dVar);
        }
        this.mTopTipsLayout.addView(g16, new ViewGroup.MarginLayoutParams(-1, this.mBlueTipsHeight));
    }

    public final void c(@NotNull List<com.qwallet.data.d> beltList) {
        Intrinsics.checkNotNullParameter(beltList, "beltList");
        this.isGetHomeRsp = true;
        this.homeBelts.clear();
        this.homeBelts.addAll(beltList);
        if (this.isGetTenpayInfo) {
            e();
        }
    }

    public final void d(@Nullable com.qwallet.data.d tenpayBelt) {
        this.isGetTenpayInfo = true;
        this.tenpayBelt = tenpayBelt;
        if (this.isGetHomeRsp) {
            e();
        }
    }
}
