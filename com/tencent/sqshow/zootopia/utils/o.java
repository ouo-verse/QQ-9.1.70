package com.tencent.sqshow.zootopia.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.api.IZPlanPAGLoaderHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0002*\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u0006\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0002*\u00020\u0006\u001a\u0014\u0010\u000b\u001a\u00020\u0002*\u00020\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\n\u001a\u0014\u0010\r\u001a\u00020\u0002*\u00020\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\f\u001a\u001e\u0010\u000f\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u000e\u001a\u001e\u0010\u0010\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a\n\u0010\u0011\u001a\u00020\u0002*\u00020\u0006\u001a\n\u0010\u0013\u001a\u00020\u0012*\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"Lpu4/t;", "other", "", "e", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lpu4/g;", "d", "l", "c", "Lpv4/u;", "g", "Lpv4/p;", "f", "", "i", tl.h.F, "b", "", "j", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class o {
    public static final boolean b(pu4.g gVar) {
        int hashCode;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        String str = gVar.f427435b;
        return str != null && ((hashCode = str.hashCode()) == 108273 ? str.equals("mp4") : hashCode == 110742 ? str.equals("pag") : hashCode == 3000872 && str.equals("apng"));
    }

    public static final boolean c(pu4.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        return Intrinsics.areEqual(gVar.f427435b, "pag");
    }

    public static final boolean d(pu4.g gVar, pu4.g gVar2) {
        boolean e16;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (gVar2 == null) {
            return false;
        }
        pu4.t pagInfo = gVar.f427438e;
        if (pagInfo == null) {
            e16 = gVar2.f427438e == null;
        } else {
            Intrinsics.checkNotNullExpressionValue(pagInfo, "pagInfo");
            e16 = e(pagInfo, gVar2.f427438e);
        }
        return TextUtils.equals(gVar.f427434a, gVar2.f427434a) && TextUtils.equals(gVar.f427435b, gVar2.f427435b) && TextUtils.equals(gVar.f427437d, gVar2.f427437d) && TextUtils.equals(gVar.f427436c, gVar2.f427436c) && e16;
    }

    public static final boolean e(pu4.t tVar, pu4.t tVar2) {
        Intrinsics.checkNotNullParameter(tVar, "<this>");
        return tVar2 != null && Arrays.equals(tVar.f427523a, tVar2.f427523a) && Arrays.equals(tVar.f427524b, tVar2.f427524b);
    }

    public static final boolean f(pv4.p pVar, pv4.p pVar2) {
        boolean d16;
        Intrinsics.checkNotNullParameter(pVar, "<this>");
        if (pVar2 == null) {
            return false;
        }
        pu4.g material = pVar.f427651a;
        if (material == null) {
            d16 = pVar2.f427651a == null;
        } else {
            Intrinsics.checkNotNullExpressionValue(material, "material");
            d16 = d(material, pVar2.f427651a);
        }
        return d16 && pVar.f427652b == pVar2.f427652b;
    }

    public static final boolean g(pv4.u uVar, pv4.u uVar2) {
        boolean d16;
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        if (uVar2 == null) {
            return false;
        }
        pu4.g material = uVar.f427705d;
        if (material == null) {
            d16 = uVar2.f427705d == null;
        } else {
            Intrinsics.checkNotNullExpressionValue(material, "material");
            d16 = d(material, uVar2.f427705d);
        }
        return TextUtils.equals(uVar.f427702a, uVar2.f427702a) && TextUtils.equals(uVar.f427703b, uVar2.f427703b) && TextUtils.equals(uVar.f427704c, uVar2.f427704c) && d16;
    }

    public static final boolean h(List<pv4.p> list, List<pv4.p> other) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (list.size() != other.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!f(list.get(i3), other.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean i(List<pv4.u> list, List<pv4.u> other) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (list.size() != other.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!g(list.get(i3), other.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (r0.equals("jpg") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if (r0.equals("gif") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0.equals("apng") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0055, code lost:
    
        r0 = r5.f427434a;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "url");
        com.tencent.sqshow.zootopia.utils.CommonExKt.o(r0, null, null, 3, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        if (r0.equals("png") == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void j(final pu4.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        String str = gVar.f427435b;
        if (str != null) {
            switch (str.hashCode()) {
                case 102340:
                    break;
                case 105441:
                    break;
                case 110742:
                    if (str.equals("pag")) {
                        PagLoader.c().f(BaseApplication.context, new PagLoader.b() { // from class: com.tencent.sqshow.zootopia.utils.n
                            @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
                            public final void onComplete(boolean z16) {
                                o.k(pu4.g.this, z16);
                            }
                        });
                        break;
                    }
                    break;
                case 111145:
                    break;
                case 3000872:
                    break;
            }
        }
        String firstFrameUrl = gVar.f427436c;
        Intrinsics.checkNotNullExpressionValue(firstFrameUrl, "firstFrameUrl");
        CommonExKt.o(firstFrameUrl, null, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(pu4.g this_preload, boolean z16) {
        Intrinsics.checkNotNullParameter(this_preload, "$this_preload");
        if (z16) {
            IZPlanPAGLoaderHelper iZPlanPAGLoaderHelper = (IZPlanPAGLoaderHelper) QRoute.api(IZPlanPAGLoaderHelper.class);
            String url = this_preload.f427434a;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            iZPlanPAGLoaderHelper.getPAGFileByUrl(url);
        }
    }

    public static final JSONObject l(pu4.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", gVar.f427434a);
        jSONObject.put("type", gVar.f427435b);
        jSONObject.put("first_frame_url", gVar.f427436c);
        jSONObject.put("first_frame_type", gVar.f427437d);
        pu4.t pagInfo = gVar.f427438e;
        if (pagInfo != null) {
            Intrinsics.checkNotNullExpressionValue(pagInfo, "pagInfo");
            jSONObject.put("pag_info", m(pagInfo));
        }
        return jSONObject;
    }

    public static final JSONObject m(pu4.t tVar) {
        Intrinsics.checkNotNullParameter(tVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        String[] pagList = tVar.f427523a;
        Intrinsics.checkNotNullExpressionValue(pagList, "pagList");
        for (String str : pagList) {
            jSONArray.mo162put(str);
        }
        jSONObject.put("pag_list", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        String[] picList = tVar.f427524b;
        Intrinsics.checkNotNullExpressionValue(picList, "picList");
        for (String str2 : picList) {
            jSONArray2.mo162put(str2);
        }
        jSONObject.put("pic_list", jSONArray2);
        return jSONObject;
    }
}
