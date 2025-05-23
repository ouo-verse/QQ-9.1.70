package com.tencent.mobileqq.basescene;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.utils.ZplanVasSmallHomeUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.helper.SmallHomeHelper;
import com.tencent.mobileqq.zootopia.portal.detail.ah;
import com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import si3.c;
import tj3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00021\bBU\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001c\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/basescene/ZplanBaseSceneDownloadButtonListener;", "Lcom/tencent/mobileqq/zplan/cloudmod/api/CloudModClickListener;", "", "f", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "type", "b", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "", "e", "J", IProfileProtocolConst.PARAM_TARGET_UIN, "Lcom/tencent/sqshow/zootopia/data/m;", "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Loa4/a;", "g", "Loa4/a;", "vm", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", tl.h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "", "", "i", "Ljava/util/Map;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/mobileqq/basescene/ZplanBaseSceneDownloadButtonListener$b;", "j", "Lcom/tencent/mobileqq/basescene/ZplanBaseSceneDownloadButtonListener$b;", "callback", "Lcom/tencent/mobileqq/zootopia/utils/k;", "k", "Lcom/tencent/mobileqq/zootopia/utils/k;", "upgradeUtils", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "l", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "<init>", "(Landroid/content/Context;JLcom/tencent/sqshow/zootopia/data/m;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/util/Map;Lcom/tencent/mobileqq/basescene/ZplanBaseSceneDownloadButtonListener$b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ZplanBaseSceneDownloadButtonListener extends CloudModClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long targetUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMapDetail detail;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final oa4.a vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> extraParams;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final b callback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.utils.k upgradeUtils;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final ah reportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/basescene/ZplanBaseSceneDownloadButtonListener$b;", "", "", "callback", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public interface b {
        void callback();
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f200298a;

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
                iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ButtonStatus.APPOINTED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f200298a = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ZplanBaseSceneDownloadButtonListener(Context context, long j3, ZootopiaMapDetail detail, oa4.a aVar, ZootopiaSource sourceCurrent, Map<String, ? extends Object> map, b bVar) {
        super(r0, sourceCurrent, r1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        int id5 = detail.getId();
        HashMap hashMap = new HashMap();
        hashMap.putAll(SmallHomeHelper.f328312a.a("3", String.valueOf(j3)));
        if (map != null) {
            hashMap.putAll(map);
        }
        Unit unit = Unit.INSTANCE;
        this.context = context;
        this.targetUin = j3;
        this.detail = detail;
        this.vm = aVar;
        this.sourceCurrent = sourceCurrent;
        this.extraParams = map;
        this.callback = bVar;
        this.upgradeUtils = new com.tencent.mobileqq.zootopia.utils.k();
        this.reportHelper = new ah(context);
    }

    private final void f() {
        ZplanVasSmallHomeUtils.f311238a.d(this.context, String.valueOf(this.targetUin), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.basescene.ZplanBaseSceneDownloadButtonListener$enterResidence$1
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
                ZootopiaMapDetail zootopiaMapDetail;
                ZootopiaSource zootopiaSource;
                Map map;
                if (z16) {
                    return;
                }
                si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
                zootopiaMapDetail = ZplanBaseSceneDownloadButtonListener.this.detail;
                int id5 = zootopiaMapDetail.getId();
                zootopiaSource = ZplanBaseSceneDownloadButtonListener.this.sourceCurrent;
                map = ZplanBaseSceneDownloadButtonListener.this.extraParams;
                c.a.a(cVar, id5, zootopiaSource, map, null, 8, null);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener
    public void b(View view, ButtonStatus type) {
        pv4.k[] kVarArr;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        com.tencent.sqshow.zootopia.report.a.c(com.tencent.sqshow.zootopia.report.a.f372690a, this.detail.getId(), type, this.sourceCurrent, null, 8, null);
        int i3 = 0;
        pv4.k kVar = null;
        switch (c.f200298a[type.ordinal()]) {
            case 1:
                f();
                b bVar = this.callback;
                if (bVar != null) {
                    bVar.callback();
                    break;
                }
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
                oa4.a aVar2 = this.vm;
                if (aVar2 != null) {
                    aVar2.R1(String.valueOf(this.detail.getId()));
                    break;
                }
                break;
            case 6:
                Context context = this.context;
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null) {
                    com.tencent.mobileqq.zootopia.utils.k.e(this.upgradeUtils, activity, null, 2, null);
                    break;
                }
                break;
            case 7:
                pv4.j reserveItem = this.detail.getReserveItem();
                if (reserveItem != null) {
                    a.C11293a.b((tj3.a) vb3.a.f441346a.a(tj3.a.class), reserveItem, false, null, 6, null);
                    break;
                }
                break;
            case 8:
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
            case 9:
                String beforeOnlineToast = this.detail.getBeforeOnlineToast();
                if (beforeOnlineToast != null) {
                    QQToast.makeText(this.context, beforeOnlineToast, 0).show();
                    break;
                }
                break;
        }
        this.reportHelper.g(view, type, this.detail.getReserveItem());
    }
}
