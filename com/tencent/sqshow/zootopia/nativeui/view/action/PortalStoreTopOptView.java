package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import b94.d;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.view.PortalStoreGroupPanelPageData;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceExitHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ce;
import uv4.au;
import uv4.az;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001NB'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\f\u00a2\u0006\u0004\bK\u0010LJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\fJ\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u001c\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J(\u0010\u001f\u001a\u00020\u00042\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J.\u0010#\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0018\u00010 2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dH\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\u0012\u0010)\u001a\u00020\u00162\b\b\u0002\u0010(\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0-H\u0002R\u0018\u00101\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020?0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020B0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010@R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020B0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010@\u00a8\u0006O"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreTopOptView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "data", "setSelectedData", "r", BdhLogUtil.LogTag.Tag_Conn, "j", "", NodeProps.VISIBLE, "setSaveBackgroundVisibilty", "Landroid/graphics/drawable/Drawable;", "drawable", "setSaveBackgroundDrawable", "style", "setStyle", "B", "t", "", "needReport", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/HashSet;", "Luv4/az;", "Lkotlin/collections/HashSet;", "items", "y", "", "", "", "k", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "showDialog", "l", DomainData.DOMAIN_NAME, "o", "p", "", "i", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Ln74/ce;", "e", "Ln74/ce;", "mBinding", "f", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "mCurrentPanelViewData", tl.h.F, "I", "mStyle", "Ljava/util/Map;", "mReportParams", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "Landroidx/lifecycle/Observer;", "mItemPoolObserver", "Lm94/a;", "mCurrentInfoObserver", "D", "mSavedInfoObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreTopOptView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final Observer<m94.a> mCurrentInfoObserver;

    /* renamed from: D, reason: from kotlin metadata */
    private final Observer<m94.a> mSavedInfoObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ce mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PortalStoreGroupPanelPageData mCurrentPanelViewData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Map<String, ? extends Object> mReportParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.nativeui.data.l> mItemPoolObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreTopOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        if (Intrinsics.areEqual(this.mBinding.f419001b.getTag(), "save") || Intrinsics.areEqual(this.mBinding.f419001b.getTag(), "buy")) {
            B();
        }
        this.mBinding.f419001b.setText(R.string.xt8);
        this.mBinding.f419001b.setTag("disable");
        this.mBinding.f419001b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.i5k));
    }

    private final void B() {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        y94.a reporter2;
        ZplanViewReportHelper mReporter2;
        if (this.mReportParams == null) {
            return;
        }
        Object tag = this.mBinding.f419001b.getTag();
        if (Intrinsics.areEqual(tag, "save")) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
            if (jVar2 == null || (reporter2 = jVar2.getReporter()) == null || (mReporter2 = reporter2.getMReporter()) == null) {
                return;
            }
            TextView textView = this.mBinding.f419001b;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.buyOrSaveBtn");
            ZplanViewReportHelper.j(mReporter2, textView, "em_zplan_avatar_save", this.mReportParams, false, null, 16, null);
            return;
        }
        if (!Intrinsics.areEqual(tag, "buy") || (jVar = this.mChannel) == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        TextView textView2 = this.mBinding.f419001b;
        Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.buyOrSaveBtn");
        ZplanViewReportHelper.j(mReporter, textView2, "em_zplan_purchase", this.mReportParams, false, null, 16, null);
    }

    private final Map<String, Object> i() {
        int collectionSizeOrDefault;
        Object obj;
        qu4.j jVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        qu4.j faceInfoWhenEnterMakeFace = jVar2 != null ? jVar2.getFaceInfoWhenEnterMakeFace() : null;
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        qu4.a k3 = cVar.k();
        qu4.j j3 = (k3 == null || (jVar = k3.f429573b) == null) ? null : bj3.a.j(jVar);
        if (faceInfoWhenEnterMakeFace != null && !r94.a.i(faceInfoWhenEnterMakeFace, j3)) {
            linkedHashMap.put("zplan_is_adjust", "1");
        } else {
            linkedHashMap.put("zplan_is_adjust", "0");
        }
        try {
            JsonArray jsonArray = new JsonArray();
            List<az> s16 = cVar.s();
            Collection<az> values = cVar.m().b().b().values();
            List<az> list = s16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (az azVar : list) {
                Iterator<T> it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((az) obj).B, azVar.B)) {
                        break;
                    }
                }
                az azVar2 = (az) obj;
                if (azVar2 != null) {
                    azVar = azVar2;
                }
                arrayList.add(azVar);
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                jsonArray.add(r94.b.J((az) it5.next()));
            }
            linkedHashMap.put("zplan_item_id", r94.b.p(s16));
            String jsonElement = jsonArray.toString();
            Intrinsics.checkNotNullExpressionValue(jsonElement, "extInfo.toString()");
            linkedHashMap.put("zplan_ext_info", jsonElement);
        } catch (Throwable th5) {
            QLog.i("PortalStoreTopOptView_", 1, "getNeedSaveItemList error", th5);
        }
        return linkedHashMap;
    }

    private final Map<String, Object> k(HashSet<az> items) {
        int collectionSizeOrDefault;
        HashMap hashMapOf;
        JsonArray jsonArray = new JsonArray();
        for (az azVar : items) {
            JsonObject J = r94.b.J(azVar);
            if (r94.b.D(azVar) || r94.b.A(azVar)) {
                J.addProperty("zplan_face_id", String.valueOf(azVar.G));
            }
            jsonArray.add(J);
        }
        Pair[] pairArr = new Pair[2];
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(r94.b.K((az) it.next()));
        }
        pairArr[0] = TuplesKt.to("zplan_item_id", arrayList);
        pairArr[1] = TuplesKt.to("zplan_ext_info", jsonArray.toString());
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf;
    }

    private final void m() {
        String str;
        ga4.f dialogController;
        ga4.g a16;
        qu4.f fVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        String zplanFaceId;
        com.tencent.sqshow.zootopia.nativeui.ue.s avatarColorController;
        Map<String, ? extends Object> i3 = i();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        String str2 = "";
        if (jVar == null || (avatarColorController = jVar.getAvatarColorController()) == null || (str = avatarColorController.getMCurrentHexColor()) == null) {
            str = "";
        }
        i3.put("zplan_color_code", str);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (zplanFaceId = jVar2.getZplanFaceId()) != null) {
            str2 = zplanFaceId;
        }
        i3.put("zplan_face_id", str2);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
        if (jVar3 != null && (reporter = jVar3.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            TextView textView = this.mBinding.f419001b;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.buyOrSaveBtn");
            mReporter.e(textView, "em_zplan_avatar_save", i3);
        }
        if (com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.A()) {
            au value = com.tencent.sqshow.zootopia.nativeui.view.experience.m.f371882a.a().getValue();
            if (((value == null || (fVar = value.f440232a) == null) ? 0L : fVar.f429591b * 1000) < NetConnInfoCenter.getServerTimeMillis()) {
                com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
                if (jVar4 != null) {
                    ga4.j jVar5 = ga4.j.f401682a;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    a16 = jVar5.a(8, jVar4, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
                    a16.show();
                    return;
                }
                return;
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar6 = this.mChannel;
        if (jVar6 != null && (dialogController = jVar6.getDialogController()) != null) {
            dialogController.d();
        }
        setStyle(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        ga4.f dialogController;
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar != null && (avatarFaceController = jVar.getAvatarFaceController()) != null) {
            avatarFaceController.j1();
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (dialogController = jVar2.getDialogController()) != null) {
            dialogController.d();
        }
        this.mStyle = 0;
        g(0, true);
    }

    private final void o(View view) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (reporter = jVar2.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            TextView textView = this.mBinding.f419001b;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.buyOrSaveBtn");
            mReporter.e(textView, "em_zplan_avatar_save", i());
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
        qu4.j d16 = (jVar3 == null || (avatarFaceController = jVar3.getAvatarFaceController()) == null) ? null : avatarFaceController.d();
        if (d16 != null && (jVar = this.mChannel) != null && (avatarDressController = jVar.getAvatarDressController()) != null) {
            d.a.g(avatarDressController, d16, false, null, 6, null);
        }
        l(false);
    }

    private final void p(View view) {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        b94.a engineApi;
        y94.a reporter2;
        ZplanViewReportHelper mReporter2;
        ga4.g a16;
        String obj = view.getTag().toString();
        QLog.d("PortalStoreTopOptView_", 1, "click But Button " + obj);
        AvatarEngineType avatarEngineType = null;
        avatarEngineType = null;
        if (Intrinsics.areEqual(obj, "buy")) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if (jVar != null) {
                ga4.f dialogController = jVar.getDialogController();
                ga4.j jVar2 = ga4.j.f401682a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                a16 = jVar2.a(22, jVar, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
                dialogController.e(a16);
            }
            com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
            if (jVar3 == null || (reporter2 = jVar3.getReporter()) == null || (mReporter2 = reporter2.getMReporter()) == null) {
                return;
            }
            TextView textView = this.mBinding.f419001b;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.buyOrSaveBtn");
            com.tencent.sqshow.zootopia.nativeui.data.cart.c cVar = com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a;
            int index = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
            com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
            mReporter2.e(textView, "em_zplan_purchase", cVar.b(index, jVar4 != null ? jVar4.getZplanFaceId() : null));
            return;
        }
        if (Intrinsics.areEqual(obj, "save")) {
            QLog.i("PortalStoreTopOptView_", 1, "save button saved:");
            com.tencent.sqshow.zootopia.nativeui.data.j jVar5 = this.mChannel;
            if (jVar5 != null && (engineApi = jVar5.getEngineApi()) != null) {
                avatarEngineType = engineApi.getType();
            }
            AvatarCommonOperateHelper.u(AvatarCommonOperateHelper.f371049a, this.mChannel, null, avatarEngineType != AvatarEngineType.UE_SMALL_HOME, 2, null, 18, null);
            com.tencent.sqshow.zootopia.nativeui.data.j jVar6 = this.mChannel;
            if (jVar6 == null || (reporter = jVar6.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
                return;
            }
            TextView textView2 = this.mBinding.f419001b;
            Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.buyOrSaveBtn");
            mReporter.e(textView2, "em_zplan_avatar_save", i());
        }
    }

    private final void q(View view) {
        QLog.d("PortalStoreTopOptView_", 1, "handle save btn " + this.mStyle);
        int i3 = this.mStyle;
        if (i3 == 0) {
            p(view);
        } else if (i3 == 1) {
            o(view);
        } else {
            if (i3 != 2) {
                return;
            }
            m();
        }
    }

    private final void t() {
        LifecycleOwner lifecycleOwner;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (lifecycleOwner = jVar.getLifecycleOwner()) == null) {
            return;
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        Intrinsics.checkNotNull(jVar2);
        jVar2.getStoreItemPool().c().observe(lifecycleOwner, this.mItemPoolObserver);
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        cVar.m().a().observe(lifecycleOwner, this.mCurrentInfoObserver);
        cVar.d().a().observe(lifecycleOwner, this.mSavedInfoObserver);
        TextView textView = this.mBinding.f419001b;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.buyOrSaveBtn");
        com.tencent.sqshow.zootopia.utils.aa.d(textView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreTopOptView.u(PortalStoreTopOptView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(PortalStoreTopOptView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.q(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(PortalStoreTopOptView this$0, m94.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h(this$0, 0, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(PortalStoreTopOptView this$0, com.tencent.sqshow.zootopia.nativeui.data.l lVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h(this$0, 0, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(PortalStoreTopOptView this$0, m94.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h(this$0, 0, false, 3, null);
    }

    private final void y(HashSet<az> items, boolean needReport) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        if (!Intrinsics.areEqual(this.mBinding.f419001b.getTag(), "buy")) {
            B();
        }
        this.mReportParams = k(items);
        CharSequence text = getContext().getText(R.string.xs5);
        this.mBinding.f419001b.setText(((Object) text) + "\u00b7" + items.size());
        this.mBinding.f419001b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.i5j));
        if ((needReport || !Intrinsics.areEqual(this.mBinding.f419001b.getTag(), "buy")) && (jVar = this.mChannel) != null && (reporter = jVar.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            TextView textView = this.mBinding.f419001b;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.buyOrSaveBtn");
            mReporter.g(textView, "em_zplan_purchase", (r16 & 4) != 0 ? null : this.mReportParams, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        this.mBinding.f419001b.setTag("buy");
    }

    private final void z(boolean needReport) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        if (!Intrinsics.areEqual(this.mBinding.f419001b.getTag(), "save")) {
            B();
        }
        this.mReportParams = i();
        this.mBinding.f419001b.setText(R.string.xt8);
        this.mBinding.f419001b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.i5j));
        if ((needReport || !Intrinsics.areEqual(this.mBinding.f419001b.getTag(), "save")) && (jVar = this.mChannel) != null && (reporter = jVar.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            TextView textView = this.mBinding.f419001b;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.buyOrSaveBtn");
            mReporter.g(textView, "em_zplan_avatar_save", (r16 & 4) != 0 ? null : this.mReportParams, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        this.mBinding.f419001b.setTag("save");
    }

    public final void C() {
        this.mBinding.f419001b.setVisibility(0);
    }

    public final void r() {
        this.mBinding.f419001b.setVisibility(8);
    }

    public final void s(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
        t();
    }

    public final void setSaveBackgroundDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mBinding.f419002c.setImageDrawable(drawable);
    }

    public final void setSaveBackgroundVisibilty(int visible) {
        this.mBinding.f419002c.setVisibility(visible);
    }

    public final void setSelectedData(PortalStoreGroupPanelPageData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mCurrentPanelViewData = data;
    }

    public final void setStyle(int style) {
        QLog.i("PortalStoreTopOptView_", 1, "setStyle style:" + style);
        g(style, true);
        this.mStyle = style;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreTopOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void j() {
        this.mReportParams = null;
    }

    public /* synthetic */ PortalStoreTopOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreTopOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ce f16 = ce.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mCurrentPanelViewData = new PortalStoreGroupPanelPageData(null, null, null, 0, false, null, 63, null);
        this.mStyle = -1;
        this.mItemPoolObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreTopOptView.w(PortalStoreTopOptView.this, (com.tencent.sqshow.zootopia.nativeui.data.l) obj);
            }
        };
        this.mCurrentInfoObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreTopOptView.v(PortalStoreTopOptView.this, (m94.a) obj);
            }
        };
        this.mSavedInfoObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreTopOptView.x(PortalStoreTopOptView.this, (m94.a) obj);
            }
        };
    }

    static /* synthetic */ void h(PortalStoreTopOptView portalStoreTopOptView, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = portalStoreTopOptView.mStyle;
        }
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        portalStoreTopOptView.g(i3, z16);
    }

    private final boolean l(boolean showDialog) {
        Activity attachedActivity;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        ga4.f dialogController;
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        if (showDialog) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
            if ((jVar2 == null || (avatarFaceController = jVar2.getAvatarFaceController()) == null || !avatarFaceController.f()) ? false : true) {
                MakeFaceExitHelper makeFaceExitHelper = MakeFaceExitHelper.f371595a;
                com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                makeFaceExitHelper.c(jVar3, context, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreTopOptView$handleBackClickOnMakeFaceStyle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar4;
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar5;
                        Activity attachedActivity2;
                        jVar4 = PortalStoreTopOptView.this.mChannel;
                        if ((jVar4 != null ? jVar4.getNativeViewMode() : null) == AvatarNativeViewMode.ONLY_MAKE_FACE) {
                            jVar5 = PortalStoreTopOptView.this.mChannel;
                            if (jVar5 == null || (attachedActivity2 = jVar5.getAttachedActivity()) == null) {
                                return;
                            }
                            attachedActivity2.finish();
                            return;
                        }
                        PortalStoreTopOptView.this.n();
                    }
                });
                jVar = this.mChannel;
                if (jVar != null && (dialogController = jVar.getDialogController()) != null) {
                    dialogController.d();
                }
                return true;
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
        if ((jVar4 != null ? jVar4.getNativeViewMode() : null) == AvatarNativeViewMode.ONLY_MAKE_FACE) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar5 = this.mChannel;
            if (jVar5 != null && (attachedActivity = jVar5.getAttachedActivity()) != null) {
                attachedActivity.finish();
            }
            return true;
        }
        setStyle(0);
        jVar = this.mChannel;
        if (jVar != null) {
            dialogController.d();
        }
        return true;
    }

    private final void g(int style, boolean needReport) {
        if (style == 1) {
            z(needReport);
            return;
        }
        if (style != 2) {
            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            HashSet<az> t16 = cVar.t(jVar != null ? jVar.getStoreItemPool() : null);
            if (true ^ t16.isEmpty()) {
                y(t16, needReport);
                return;
            } else if (cVar.B()) {
                z(needReport);
                return;
            } else {
                A();
                return;
            }
        }
        z(needReport);
    }
}
