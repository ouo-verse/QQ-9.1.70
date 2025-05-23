package ha4;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.data.sort.CombineOrderFilterData;
import com.tencent.sqshow.zootopia.nativeui.data.sort.PanelSortDialogData;
import ga4.g;
import java.util.ArrayList;
import java.util.Iterator;
import k94.ColorPanelData;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.ah;
import uv4.ao;
import uv4.ap;
import uv4.ar;
import uv4.as;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\"\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lha4/b;", "", "", "orderTypeSize", "", "c", "Luv4/as;", "colorEditorCfg", "itemIndex", "useNewPortalStore", "", "f", "Luv4/ao;", "storeCategoryCfgV1", "currentOrderType", "g", "a", "colorCfg", "b", "d", "categoryCfg", "e", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;Landroid/content/Context;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final j channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lha4/b$a;", "", "Luv4/ao;", "categoryCfg", "", "b", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ha4.b$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(ao categoryCfg) {
            Intrinsics.checkNotNullParameter(categoryCfg, "categoryCfg");
            return categoryCfg.f440184b == -4;
        }

        public final boolean b(ao categoryCfg) {
            Intrinsics.checkNotNullParameter(categoryCfg, "categoryCfg");
            int i3 = categoryCfg.f440184b;
            return i3 == -2 || i3 == -3;
        }

        Companion() {
        }
    }

    public b(j channel, Context context) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(context, "context");
        this.channel = channel;
        this.context = context;
    }

    private final boolean c(int orderTypeSize) {
        if (orderTypeSize > 1) {
            return true;
        }
        return false;
    }

    public final boolean a(ao storeCategoryCfgV1) {
        Intrinsics.checkNotNullParameter(storeCategoryCfgV1, "storeCategoryCfgV1");
        int length = storeCategoryCfgV1.f440194l.length;
        if (storeCategoryCfgV1.f440195m.length > 0) {
            return true;
        }
        return c(length);
    }

    public final boolean b(as colorCfg) {
        if (colorCfg != null) {
            return true;
        }
        return false;
    }

    public final void e(ao categoryCfg, int currentOrderType) {
        Intrinsics.checkNotNullParameter(categoryCfg, "categoryCfg");
        if (!a(categoryCfg)) {
            QLog.e("PanelSortAndFilterController_", 1, "onSortAndFilterFilterEntranceClick can't show!");
        } else if (c(categoryCfg.f440194l.length)) {
            g(categoryCfg, currentOrderType);
        }
    }

    public final void d(as colorCfg, int itemIndex, boolean useNewPortalStore) {
        if (colorCfg == null) {
            return;
        }
        f(colorCfg, itemIndex, useNewPortalStore);
    }

    private final void f(as colorEditorCfg, int itemIndex, boolean useNewPortalStore) {
        qu4.c pb5;
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController == null || (pb5 = avatarDressController.pb()) == null) {
            return;
        }
        int i3 = colorEditorCfg.f440218a;
        QLog.i("PanelSortAndFilterController_", 1, "showColorEditDialog slotId:" + i3);
        ga4.j jVar = ga4.j.f401682a;
        j jVar2 = this.channel;
        Context context = this.context;
        DialogCustomData dialogCustomData = new DialogCustomData(null, null, null, null, null, 0, 63, null);
        dialogCustomData.g(new ColorPanelData(i3, pb5, colorEditorCfg, itemIndex));
        Unit unit = Unit.INSTANCE;
        jVar.a(7, jVar2, context, dialogCustomData, useNewPortalStore).show();
    }

    private final void g(ao storeCategoryCfgV1, int currentOrderType) {
        g a16;
        Object obj;
        Object obj2;
        String str;
        ArrayList arrayList = new ArrayList();
        int[] iArr = storeCategoryCfgV1.f440194l;
        Intrinsics.checkNotNullExpressionValue(iArr, "storeCategoryCfgV1.orderTypes");
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            Object obj3 = null;
            if (i3 >= length) {
                break;
            }
            int i16 = iArr[i3];
            Iterator<T> it = this.channel.getPanelSortData().d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((ar) next).f440215a == i16) {
                    obj3 = next;
                    break;
                }
            }
            ar arVar = (ar) obj3;
            if (arVar != null) {
                arrayList.add(arVar);
            }
            i3++;
        }
        ArrayList arrayList2 = new ArrayList();
        int[] iArr2 = storeCategoryCfgV1.f440195m;
        Intrinsics.checkNotNullExpressionValue(iArr2, "storeCategoryCfgV1.filterTypes");
        int length2 = iArr2.length;
        for (int i17 = 0; i17 < length2; i17++) {
            int i18 = iArr2[i17];
            Iterator<T> it5 = this.channel.getPanelSortData().b().iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (((ap) obj).f440199a == i18) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ap apVar = (ap) obj;
            Iterator<T> it6 = this.channel.getPanelSortData().c().iterator();
            while (true) {
                if (it6.hasNext()) {
                    obj2 = it6.next();
                    if (((ah) obj2).f440138a == i18) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            ah ahVar = (ah) obj2;
            if (apVar != null) {
                if (ahVar == null || (str = ahVar.f440139b) == null) {
                    str = apVar.f440203e;
                }
                ah ahVar2 = new ah();
                ahVar2.f440138a = i18;
                ahVar2.f440139b = str;
                arrayList2.add(new CombineOrderFilterData(apVar, ahVar2));
            }
        }
        a16 = ga4.j.f401682a.a(4, this.channel, this.context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, new PanelSortDialogData(currentOrderType, arrayList, arrayList2), null, null, null, 0, 61, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }
}
