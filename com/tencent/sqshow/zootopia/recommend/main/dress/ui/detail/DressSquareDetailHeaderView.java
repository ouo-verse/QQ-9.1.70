package com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDressDetailSettingsEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailHeaderView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.w;
import eb4.a;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.aw;
import pu4.j;
import pu4.n;
import pu4.s;
import q84.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002ABB#\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010;\u001a\u000203\u00a2\u0006\u0004\b<\u0010=B\u0013\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b<\u0010>B\u001f\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b<\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J$\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nH\u0002J,\u0010\u0011\u001a\u00020\u00032\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010%R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R6\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010%R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006C"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView;", "Landroid/widget/RelativeLayout;", "Lq84/c;", "", "f", "c", "j", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "e", "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/data/g;", "Lkotlin/collections/ArrayList;", "data", "sourceId", "i", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView$b;", "listener", "setDismissListener", "Lq84/b;", "selectInfo", "w", UserInfo.SEX_FEMALE, "H", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "l", ExifInterface.LATITUDE_SOUTH, "Ln74/aw;", "d", "Ln74/aw;", "()Ln74/aw;", "binding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Ljava/lang/String;", h.F, "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView$b;", "getListener", "()Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView$b;", "setListener", "(Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView$b;)V", "Ljava/util/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selfUin", "", BdhLogUtil.LogTag.Tag_Conn, "I", "currentPos", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressSquareDetailHeaderView extends RelativeLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private int currentPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final aw binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String sourceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b listener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ZootopiaDetailFeedsCardData> data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String selfUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView$b;", "", "", "dismiss", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void dismiss();
    }

    public DressSquareDetailHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        aw g16 = aw.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        this.reportHelper = new ZplanViewReportHelper();
        this.selfUin = "";
    }

    private final void c() {
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        zplanViewReportHelper.a(context, root, "pg_zplan_outfit_detail", e());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if ((!r0.isEmpty()) == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final HashMap<String, Object> e() {
        boolean z16;
        ArrayList<ZootopiaDetailFeedsCardData> arrayList;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData;
        if (this.data != null) {
            z16 = true;
        }
        z16 = false;
        n nVar = null;
        if (z16) {
            ArrayList<ZootopiaDetailFeedsCardData> arrayList2 = this.data;
            int size = arrayList2 != null ? arrayList2.size() : 0;
            int i3 = this.currentPos;
            if (size > i3 && (arrayList = this.data) != null && (zootopiaDetailFeedsCardData = arrayList.get(i3)) != null) {
                nVar = zootopiaDetailFeedsCardData.getOutfitWorksInfo();
            }
        }
        return a.f396070a.a(nVar, this.sourceId);
    }

    private final void f() {
        RelativeLayout relativeLayout = this.binding.f418762c;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.backRl");
        aa.d(relativeLayout, new View.OnClickListener() { // from class: jb4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailHeaderView.g(DressSquareDetailHeaderView.this, view);
            }
        });
        RelativeLayout relativeLayout2 = this.binding.f418764e;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.privacyRl");
        aa.d(relativeLayout2, new View.OnClickListener() { // from class: jb4.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailHeaderView.h(DressSquareDetailHeaderView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DressSquareDetailHeaderView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        HashMap<String, Object> e16 = this$0.e();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.b(zplanViewReportHelper, e16, it, "em_zplan_back_btn");
        QLog.d("DressSquareDetailHeaderView", 1, "click header back icon, finish");
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DressSquareDetailHeaderView this$0, View view) {
        j jVar;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<ZootopiaDetailFeedsCardData> arrayList = this$0.data;
        String str = null;
        n outfitWorksInfo = (arrayList == null || (zootopiaDetailFeedsCardData = arrayList.get(this$0.currentPos)) == null) ? null : zootopiaDetailFeedsCardData.getOutfitWorksInfo();
        QLog.d("DressSquareDetailHeaderView", 1, "click header top setting layout, outfitWorksInfo: " + outfitWorksInfo);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (outfitWorksInfo != null && (jVar = outfitWorksInfo.f427498a) != null) {
            str = jVar.f427462a;
        }
        if (str == null) {
            str = "";
        }
        simpleEventBus.dispatchEvent(new ZplanDressDetailSettingsEvent(str));
    }

    private final void j() {
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData2;
        n outfitWorksInfo;
        s sVar;
        ArrayList<ZootopiaDetailFeedsCardData> arrayList = this.data;
        if (arrayList != null && arrayList.isEmpty()) {
            return;
        }
        ArrayList<ZootopiaDetailFeedsCardData> arrayList2 = this.data;
        if (w.f373306a.c(String.valueOf((arrayList2 == null || (zootopiaDetailFeedsCardData2 = arrayList2.get(this.currentPos)) == null || (outfitWorksInfo = zootopiaDetailFeedsCardData2.getOutfitWorksInfo()) == null || (sVar = outfitWorksInfo.f427500c) == null) ? 0L : sVar.f427518a))) {
            ArrayList<ZootopiaDetailFeedsCardData> arrayList3 = this.data;
            if ((arrayList3 == null || (zootopiaDetailFeedsCardData = arrayList3.get(this.currentPos)) == null || zootopiaDetailFeedsCardData.getStatus() != 0) ? false : true) {
                this.binding.f418764e.setVisibility(0);
                return;
            }
        }
        this.binding.f418764e.setVisibility(8);
    }

    @Override // q84.c
    public void F(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
    }

    @Override // q84.c
    public void H(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
    }

    @Override // q84.c
    public void S(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
    }

    /* renamed from: d, reason: from getter */
    public final aw getBinding() {
        return this.binding;
    }

    public final void i(ArrayList<ZootopiaDetailFeedsCardData> data, String sourceId) {
        this.sourceId = sourceId;
        this.data = data;
        j();
    }

    @Override // q84.c
    public void l(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        this.currentPos = selectInfo.getMPosition();
        c();
        a aVar = a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        HashMap<String, Object> e16 = e();
        ImageView imageView = this.binding.f418761b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backIv");
        aVar.c(zplanViewReportHelper, e16, imageView, "em_zplan_back_btn");
        j();
    }

    public final void setData(ArrayList<ZootopiaDetailFeedsCardData> arrayList) {
        this.data = arrayList;
    }

    public final void setDismissListener(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setListener(b bVar) {
        this.listener = bVar;
    }

    @Override // q84.c
    public void w(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
    }

    public DressSquareDetailHeaderView(Context context) {
        this(context, null);
    }

    public DressSquareDetailHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        addView(this.binding.getRoot(), -1, -1);
        this.selfUin = w.f373306a.b();
        f();
    }

    @Override // q84.c
    public void onDestroy() {
    }
}
