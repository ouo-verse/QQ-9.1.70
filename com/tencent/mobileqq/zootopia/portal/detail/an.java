package com.tencent.mobileqq.zootopia.portal.detail;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import si3.c;
import tj3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)BA\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/an;", "Lcom/tencent/mobileqq/zplan/cloudmod/api/CloudModClickListener;", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "type", "", "b", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/data/m;", "e", "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Loa4/a;", "f", "Loa4/a;", "vm", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "g", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "", "", tl.h.F, "Ljava/util/Map;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/mobileqq/zootopia/utils/k;", "i", "Lcom/tencent/mobileqq/zootopia/utils/k;", "upgradeUtils", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "j", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/data/m;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/util/Map;)V", "k", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class an extends CloudModClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMapDetail detail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final oa4.a vm;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> extraParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.utils.k upgradeUtils;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final ah reportHelper;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328751a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ButtonStatus.LOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ButtonStatus.WAITING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ButtonStatus.APPOINTED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ButtonStatus.CLOUD_GAME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f328751a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/an$c", "Lcom/tencent/mobileqq/zplan/cloudmod/api/b;", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zplan.cloudmod.api.b {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.cloudmod.api.b
        public void b() {
            oa4.a aVar = an.this.vm;
            if (aVar != null) {
                oa4.a.W1(aVar, an.this.detail, false, 2, null);
            }
        }

        @Override // com.tencent.mobileqq.zplan.cloudmod.api.b
        public void a() {
            QLog.d("ZootopiaDownloadButtonListener", 1, "onEnterMod");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(Context context, ZootopiaMapDetail detail, oa4.a aVar, ZootopiaSource sourceCurrent, Map<String, ? extends Object> map) {
        super(detail.getId(), sourceCurrent, map);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.context = context;
        this.detail = detail;
        this.vm = aVar;
        this.sourceCurrent = sourceCurrent;
        this.extraParams = map;
        this.upgradeUtils = new com.tencent.mobileqq.zootopia.utils.k();
        this.reportHelper = new ah(context);
    }

    @Override // com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener
    public void b(View view, ButtonStatus type) {
        pv4.k[] kVarArr;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        this.reportHelper.g(view, type, this.detail.getReserveItem());
        com.tencent.sqshow.zootopia.report.a.c(com.tencent.sqshow.zootopia.report.a.f372690a, this.detail.getId(), type, this.sourceCurrent, null, 8, null);
        int i3 = 0;
        pv4.k kVar = null;
        switch (b.f328751a[type.ordinal()]) {
            case 1:
                c.a.a((si3.c) vb3.a.f441346a.a(si3.c.class), this.detail.getId(), this.sourceCurrent, this.extraParams, null, 8, null);
                break;
            case 2:
            case 3:
            case 4:
                oa4.a aVar = this.vm;
                if (aVar != null) {
                    oa4.a.W1(aVar, this.detail, false, 2, null);
                    break;
                }
                break;
            case 5:
            case 6:
                oa4.a aVar2 = this.vm;
                if (aVar2 != null) {
                    aVar2.R1(String.valueOf(this.detail.getId()));
                    break;
                }
                break;
            case 7:
                Context context = this.context;
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null) {
                    com.tencent.mobileqq.zootopia.utils.k.e(this.upgradeUtils, activity, null, 2, null);
                    break;
                }
                break;
            case 8:
                pv4.j reserveItem = this.detail.getReserveItem();
                if (reserveItem != null) {
                    a.C11293a.b((tj3.a) vb3.a.f441346a.a(tj3.a.class), reserveItem, false, null, 6, null);
                    break;
                }
                break;
            case 9:
                pv4.j reserveItem2 = this.detail.getReserveItem();
                if (reserveItem2 != null) {
                    tj3.a aVar3 = (tj3.a) vb3.a.f441346a.a(tj3.a.class);
                    String str = reserveItem2.f427619b;
                    Intrinsics.checkNotNullExpressionValue(str, "it.id");
                    pv4.j o16 = aVar3.o(str, reserveItem2.f427618a);
                    if (o16 != null && (kVarArr = o16.f427623f) != null) {
                        int length = kVarArr.length;
                        while (true) {
                            if (i3 < length) {
                                pv4.k findConfig = kVarArr[i3];
                                Intrinsics.checkNotNullExpressionValue(findConfig, "findConfig");
                                if (com.tencent.mobileqq.zootopia.utils.g.j(findConfig)) {
                                    kVar = findConfig;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        if (kVar != null && !kVar.f427628d) {
                            ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).E0(reserveItem2);
                            break;
                        }
                    }
                }
                break;
            case 10:
                String beforeOnlineToast = this.detail.getBeforeOnlineToast();
                if (beforeOnlineToast != null) {
                    QQToast.makeText(this.context, beforeOnlineToast, 0).show();
                    break;
                }
                break;
            case 11:
                ZPlanCloudGameInfo cloudGameInfo = this.detail.getCloudGameInfo();
                if (cloudGameInfo != null) {
                    ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).S0(cloudGameInfo, this.detail.getId(), this.detail.getMapStatus(), this.context, new c());
                    break;
                }
                break;
        }
        i.a.b(ZplanGuideManager.INSTANCE.a(), 7, 12, 0, 4, null);
    }
}
