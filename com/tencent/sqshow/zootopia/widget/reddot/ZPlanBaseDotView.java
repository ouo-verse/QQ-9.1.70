package com.tencent.sqshow.zootopia.widget.reddot;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import gv4.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import xv4.ab;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0016J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\tH\u0014J\u0006\u0010\u0014\u001a\u00020\u0013R\u001a\u0010\u0019\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u0015\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0014\u0010 \u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00061"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanBaseDotView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/widget/reddot/c;", "Lgv4/e;", "redDotData", "", "b", "", "scene", "", "g", "j", NodeProps.ON_ATTACHED_TO_WINDOW, "a", "reddotId", h.F, "c", "i", NodeProps.ON_DETACHED_FROM_WINDOW, "", "f", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "TAG", "I", "portalReddotId", "()I", "setReddotStatus", "(I)V", "reddotStatus", "PORTAL_DRESS_REDDOT_ID", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "specialIdList", BdhLogUtil.LogTag.Tag_Conn, "Lgv4/e;", "lastRedDotData", "D", "Z", "hasRendered", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class ZPlanBaseDotView extends FrameLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private volatile gv4.e lastRedDotData;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean hasRendered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int portalReddotId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int reddotStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int scene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int PORTAL_DRESS_REDDOT_ID;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<Integer> specialIdList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseDotView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String b(gv4.e redDotData) {
        List asList;
        StringBuilder sb5 = new StringBuilder("redDotData = {");
        sb5.append("[moduleIndex=" + redDotData.f403425a + ",");
        sb5.append("showType=" + redDotData.f403426b + ", ");
        sb5.append("showNum=" + redDotData.f403427c + ", ");
        sb5.append("showText=" + redDotData.f403428d + ", ");
        sb5.append("showIcon=" + redDotData.f403429e + "], ");
        f fVar = redDotData.f403430f;
        if (fVar != null) {
            sb5.append("[portalPopSec=" + fVar.f403431a + ", ");
            sb5.append("duringSec=" + fVar.f403432b + ", ");
            sb5.append("coldSec=" + fVar.f403433c + ", ");
            sb5.append("rewardType=" + fVar.f403434d + "], ");
            ab[] abVarArr = fVar.f403435e;
            Intrinsics.checkNotNullExpressionValue(abVarArr, "it.spMaterial");
            asList = ArraysKt___ArraysJvmKt.asList(abVarArr);
            List list = asList;
            if (list == null || list.isEmpty()) {
                sb5.append("[spMaterial=null]}");
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "logBuilder.toString()");
                return sb6;
            }
            int size = asList.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb5.append("[pag url=" + ((ab) asList.get(i3)).f448769b + ", ");
                sb5.append("pag loopCnt=" + ((ab) asList.get(i3)).f448770c + "]");
            }
        }
        sb5.append("}");
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "logBuilder.toString()");
        return sb7;
    }

    @Override // com.tencent.sqshow.zootopia.widget.reddot.c
    public void a() {
        int i3 = this.portalReddotId;
        if (i3 > 0) {
            h(i3);
        }
    }

    /* renamed from: d, reason: from getter */
    public final int getReddotStatus() {
        return this.reddotStatus;
    }

    /* renamed from: e, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    public final boolean f() {
        return this.specialIdList.contains(Integer.valueOf(this.portalReddotId));
    }

    public void g(@RedDotScene int scene) {
        this.scene = scene;
    }

    public final void h(int reddotId) {
        c();
        this.portalReddotId = reddotId;
        gv4.e l3 = ZPlanRedDotManager.f373437a.l(reddotId, this.scene);
        if (f() && this.hasRendered) {
            QLog.d(this.TAG, 4, "id: " + this.portalReddotId + ", in view's lifecycle, do not render repeat");
            return;
        }
        if (l3 == null) {
            setVisibility(4);
        } else {
            QLog.d(this.TAG, 4, "refreshWithSceneIndex, scene:" + this.scene + ", RedDotId:" + reddotId + ", " + b(l3));
            i(l3);
            this.hasRendered = true;
        }
        this.lastRedDotData = l3;
    }

    public abstract void i(gv4.e redDotData);

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ZPlanRedDotManager.f373437a.r(this);
        int i3 = this.portalReddotId;
        if (i3 > 0) {
            h(i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ZPlanRedDotManager.f373437a.A(this);
    }

    public final void setReddotStatus(int i3) {
        this.reddotStatus = i3;
    }

    public /* synthetic */ ZPlanBaseDotView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public void j() {
        this.portalReddotId = -1;
        this.reddotStatus = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ZPlanRedDotView";
        this.portalReddotId = -1;
        this.PORTAL_DRESS_REDDOT_ID = 11;
        ArrayList arrayList = new ArrayList();
        arrayList.add(11);
        this.specialIdList = arrayList;
    }

    public void c() {
    }
}
