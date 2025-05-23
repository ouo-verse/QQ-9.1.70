package com.tencent.mobileqq.zplan.reservation.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.mobileqq.zplan.reservation.impl.data.ReserveListEntity;
import com.tencent.mobileqq.zplan.reservation.impl.fragment.ReservationManageFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import pv4.j;
import pv4.k;
import pv4.m;
import qv4.ac;
import qv4.ad;
import qv4.ax;
import qv4.ay;
import qv4.be;
import qv4.bf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0003J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J \u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u001e\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0\"H\u0016J&\u0010*\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\"H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110+H\u0016J\u001a\u0010/\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\bH\u0016J \u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0004H\u0016J \u00103\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u001cH\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0016J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0002H\u0016J\u001e\u0010:\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u0002090\"H\u0016R!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00110+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/zplan/reservation/impl/ReservationImpl;", "Ltj3/a;", "Lpv4/j;", "reserveItem", "", "isSuccess", "", "t1", "", "mapId", "", "", "", "j1", "Lpv4/m;", "remindInfo", "q1", "Lqv4/ad;", "value", "x1", "Landroid/view/View$OnClickListener;", "cancelClickListener", "Landroid/view/View;", "i1", "Lcom/tencent/widget/Switch;", "switchWifi", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "l1", "Lpv4/k;", "wifiConfig", "isChecked", "p1", "u1", "needRemind", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bf;", "callback", "s0", "Lqv4/b;", "J", "reservationType", "reserveStatus", "i", "Landroidx/lifecycle/MutableLiveData;", "r0", "reserveId", "reserveType", "o", "reserved", "z1", "reserveItemConfig", "y1", "Landroid/content/Context;", "context", "u0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "E0", "Lqv4/ay;", BdhLogUtil.LogTag.Tag_Req, "b", "Lkotlin/Lazy;", "k1", "()Landroidx/lifecycle/MutableLiveData;", "reservationData", "Lid3/d;", "c", "Lid3/d;", "dtReportHelper", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ReservationImpl implements tj3.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy reservationData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private id3.d dtReportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/ReservationImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<qv4.b> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ j f335079e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<qv4.b> f335080f;

        b(j jVar, com.tencent.mobileqq.zootopia.api.e<qv4.b> eVar) {
            this.f335079e = jVar;
            this.f335080f = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(qv4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ReservationImpl", 1, "cancelReservation onResultSuccess");
            ReservationImpl reservationImpl = ReservationImpl.this;
            j jVar = this.f335079e;
            int i3 = jVar.f427618a;
            String str = jVar.f427619b;
            Intrinsics.checkNotNullExpressionValue(str, "reserveItem.id");
            reservationImpl.z1(i3, str, false);
            ((si3.b) vb3.a.f441346a.a(si3.b.class)).Q("cancel reserve", true);
            this.f335080f.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ReservationImpl", 1, "cancelReservation onResultFailure");
            this.f335080f.onResultFailure(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/ReservationImpl$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ay;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<ay> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ay> f335087e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f335088f;

        d(com.tencent.mobileqq.zootopia.api.e<ay> eVar, j jVar) {
            this.f335087e = eVar;
            this.f335088f = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ay result) {
            j[] jVarArr;
            j jVar;
            Intrinsics.checkNotNullParameter(result, "result");
            ad adVar = (ad) ReservationImpl.this.k1().getValue();
            if (adVar != null && (jVarArr = adVar.f429902a) != null) {
                j jVar2 = this.f335088f;
                int length = jVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        jVar = null;
                        break;
                    }
                    jVar = jVarArr[i3];
                    if (jVar.f427618a == jVar2.f427618a && Intrinsics.areEqual(jVar.f427619b, jVar2.f427619b)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (jVar != null) {
                    j jVar3 = this.f335088f;
                    ReservationImpl reservationImpl = ReservationImpl.this;
                    jVar.f427623f = jVar3.f427623f;
                    reservationImpl.k1().postValue(reservationImpl.k1().getValue());
                    T value = reservationImpl.k1().getValue();
                    Intrinsics.checkNotNull(value);
                    reservationImpl.x1((ad) value);
                }
            }
            this.f335087e.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ReservationImpl", 1, "modifyReserveConfig error:" + error + ", message:" + message);
            this.f335087e.onResultFailure(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/ReservationImpl$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ad;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<ad> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ad> f335090e;

        e(com.tencent.mobileqq.zootopia.api.e<ad> eVar) {
            this.f335090e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ad result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ReservationImpl", 1, "refreshReservationList onResultSuccess");
            ReservationImpl.this.k1().postValue(result);
            ReservationImpl.this.x1(result);
            this.f335090e.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ReservationImpl", 1, "refreshReservationList onResultFailure error:" + error + ", message:" + message);
            ReservationImpl.this.k1().postValue(null);
            this.f335090e.onResultFailure(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/ReservationImpl$f", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bf;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements com.tencent.mobileqq.zootopia.api.e<bf> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ j f335092e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f335093f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bf> f335094h;

        f(j jVar, boolean z16, com.tencent.mobileqq.zootopia.api.e<bf> eVar) {
            this.f335092e = jVar;
            this.f335093f = z16;
            this.f335094h = eVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
        
            if (r1 == null) goto L36;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(bf result) {
            j jVar;
            Object firstOrNull;
            j[] jVarArr;
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ReservationImpl", 1, "reservation onResultSuccess result:" + result);
            j[] jVarArr2 = result.f430056a;
            j jVar2 = null;
            if (jVarArr2 != null) {
                j jVar3 = this.f335092e;
                int length = jVarArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    j it = jVarArr2[i3];
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (com.tencent.mobileqq.zootopia.utils.g.b(it, jVar3)) {
                        jVar2 = it;
                        break;
                    }
                    i3++;
                }
            }
            if (jVar2 != null) {
                ad adVar = (ad) ReservationImpl.this.k1().getValue();
                if (adVar != null && (jVarArr = adVar.f429902a) != null) {
                    ReservationImpl reservationImpl = ReservationImpl.this;
                    for (j cacheItem : jVarArr) {
                        Intrinsics.checkNotNullExpressionValue(cacheItem, "cacheItem");
                        if (com.tencent.mobileqq.zootopia.utils.g.b(cacheItem, jVar2)) {
                            com.tencent.mobileqq.zootopia.utils.g.a(cacheItem, jVar2);
                            reservationImpl.k1().postValue(reservationImpl.k1().getValue());
                        }
                    }
                }
                if (jVar2.f427622e != null) {
                    m[] mVarArr = this.f335092e.f427622e;
                    Intrinsics.checkNotNullExpressionValue(mVarArr, "reserveItem.remindInfo");
                    for (m remindItem : mVarArr) {
                        ReservationImpl reservationImpl2 = ReservationImpl.this;
                        Intrinsics.checkNotNullExpressionValue(remindItem, "remindItem");
                        reservationImpl2.q1(remindItem);
                    }
                }
                if (this.f335092e.f427618a == 1) {
                    ZootopiaMapStatusManager zootopiaMapStatusManager = ZootopiaMapStatusManager.f370743d;
                    String str = jVar2.f427619b;
                    Intrinsics.checkNotNullExpressionValue(str, "resultItem.id");
                    zootopiaMapStatusManager.l(str, 12);
                }
                ReservationImpl reservationImpl3 = ReservationImpl.this;
                int i16 = jVar2.f427618a;
                String str2 = jVar2.f427619b;
                Intrinsics.checkNotNullExpressionValue(str2, "resultItem.id");
                reservationImpl3.z1(i16, str2, true);
            }
            if (this.f335093f) {
                QQToastUtil.showQQToast(2, R.string.f169740xc0);
                ReservationImpl reservationImpl4 = ReservationImpl.this;
                j[] jVarArr3 = result.f430056a;
                if (jVarArr3 != null) {
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(jVarArr3);
                    jVar = (j) firstOrNull;
                }
                jVar = this.f335092e;
                reservationImpl4.E0(jVar);
            }
            ((si3.b) vb3.a.f441346a.a(si3.b.class)).Q("after reserve", true);
            this.f335094h.onResultSuccess(result);
            ReservationImpl.this.t1(this.f335092e, true);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ReservationImpl", 1, "reservation onResultFailure error:" + error + ", message:" + message);
            this.f335094h.onResultFailure(error, message);
            ReservationImpl.this.t1(this.f335092e, false);
        }
    }

    public ReservationImpl() {
        Lazy lazy;
        Object obj;
        Object firstOrNull;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MutableLiveData<ad>>() { // from class: com.tencent.mobileqq.zplan.reservation.impl.ReservationImpl$reservationData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MutableLiveData<ad> invoke() {
                return new MutableLiveData<>();
            }
        });
        this.reservationData = lazy;
        this.dtReportHelper = new id3.d(null, 1, null);
        List<? extends Entity> k3 = ZplanDataBaseHelper.h().k(ReserveListEntity.class);
        if (k3 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) k3);
            obj = (Entity) firstOrNull;
        } else {
            obj = null;
        }
        final ReserveListEntity reserveListEntity = obj instanceof ReserveListEntity ? (ReserveListEntity) obj : null;
        if (reserveListEntity != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.zplan.reservation.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    ReservationImpl.c1(ReservationImpl.this, reserveListEntity);
                }
            });
        } else {
            k1().setValue(new ad());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(ReservationImpl this$0, ReserveListEntity reserveListEntity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ReservationImpl", 1, "init update livedata");
        this$0.k1().setValue(ReserveListEntity.INSTANCE.b(reserveListEntity));
    }

    private final View i1(j reserveItem, View.OnClickListener cancelClickListener) {
        k kVar = null;
        View contentView = LayoutInflater.from(MobileQQ.sMobileQQ).inflate(R.layout.f167430d94, (ViewGroup) null);
        Switch switchWifi = (Switch) contentView.findViewById(R.id.qp5);
        String str = reserveItem.f427619b;
        Intrinsics.checkNotNullExpressionValue(str, "reserveItem.id");
        j o16 = o(str, reserveItem.f427618a);
        if (o16 != null) {
            k[] kVarArr = o16.f427623f;
            if (kVarArr != null) {
                int length = kVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    k config = kVarArr[i3];
                    Intrinsics.checkNotNullExpressionValue(config, "config");
                    if (com.tencent.mobileqq.zootopia.utils.g.j(config)) {
                        kVar = config;
                        break;
                    }
                    i3++;
                }
                if (kVar != null) {
                    switchWifi.setChecked(kVar.f427628d);
                }
            }
            Intrinsics.checkNotNullExpressionValue(switchWifi, "switchWifi");
            switchWifi.setOnCheckedChangeListener(l1(switchWifi, o16));
            ((RelativeLayout) contentView.findViewById(R.id.pfh)).setOnClickListener(cancelClickListener);
        }
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        return contentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableLiveData<ad> k1() {
        return (MutableLiveData) this.reservationData.getValue();
    }

    private final CompoundButton.OnCheckedChangeListener l1(final Switch switchWifi, final j reserveItem) {
        return new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zplan.reservation.impl.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ReservationImpl.m1(j.this, this, switchWifi, compoundButton, z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(ReservationImpl this$0, k wifiConfig, boolean z16, j reserveItem, Switch switchWifi, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(wifiConfig, "$wifiConfig");
        Intrinsics.checkNotNullParameter(reserveItem, "$reserveItem");
        Intrinsics.checkNotNullParameter(switchWifi, "$switchWifi");
        this$0.p1(wifiConfig, z16, reserveItem, switchWifi);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(ReservationImpl this$0, Switch switchWifi, boolean z16, j reserveItem, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchWifi, "$switchWifi");
        Intrinsics.checkNotNullParameter(reserveItem, "$reserveItem");
        this$0.u1(switchWifi, z16, reserveItem);
        dialogInterface.dismiss();
    }

    private final void p1(k wifiConfig, boolean isChecked, j reserveItem, Switch switchWifi) {
        wifiConfig.f427628d = isChecked;
        R(reserveItem, new c(reserveItem, wifiConfig, switchWifi, isChecked));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(final m remindInfo) {
        QLog.i("ReservationImpl", 1, "registerQQNotify remindInfo:" + remindInfo);
        ae.k(remindInfo.f427632a, remindInfo.f427634c, remindInfo.f427633b, new ae.b() { // from class: com.tencent.mobileqq.zplan.reservation.impl.e
            @Override // com.tencent.mobileqq.activity.activateFriend.ae.b
            public final void queryHasSetNotify(Bundle bundle, Bundle bundle2) {
                ReservationImpl.r1(m.this, bundle, bundle2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(m remindInfo, Bundle bundle, Bundle bundle2) {
        Intrinsics.checkNotNullParameter(remindInfo, "$remindInfo");
        Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("retcode")) : null;
        String string = bundle != null ? bundle.getString("retmsg") : null;
        Integer valueOf2 = bundle != null ? Integer.valueOf(bundle.getInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE)) : null;
        if (valueOf != null && valueOf.intValue() == 0 && valueOf2 != null && valueOf2.intValue() == 1) {
            QLog.i("ReservationImpl", 1, "registerQQNotify \u5df2\u7ecf\u8ba2\u9605\u8fc7\uff0c\u65e0\u9700\u91cd\u65b0\u8ba2\u9605 has reserved");
            return;
        }
        QLog.i("ReservationImpl", 1, "registerQQNotify reserve silence \u89e6\u53d1\u9759\u9ed8\u8ba2\u9605 retCode:" + valueOf + " retMsg:" + string + ", hasSubscribe:" + valueOf2);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        Activity topActivity = Foreground.getTopActivity();
        Intrinsics.checkNotNull(topActivity, "null cannot be cast to non-null type mqq.app.AppActivity");
        ae.r(appInterface, (AppActivity) topActivity, remindInfo.f427632a, remindInfo.f427634c, remindInfo.f427633b, "1", new ae.c() { // from class: com.tencent.mobileqq.zplan.reservation.impl.h
            @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
            public final void onResult(Bundle bundle3, Bundle bundle4) {
                ReservationImpl.s1(bundle3, bundle4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        actionSheet.dismiss();
    }

    @Override // tj3.a
    public void E0(j item) {
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("ReservationImpl", 1, "showReserveConfigDialog");
        Dialog createDialog = ActionSheetHelper.createDialog(Foreground.getTopActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setActionContentView(i1(item, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.reservation.impl.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationImpl.v1(ActionSheet.this, view);
            }
        }), new LinearLayout.LayoutParams(-1, -2));
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.reservation.impl.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationImpl.w1(ActionSheet.this, view);
            }
        });
        actionSheet.show();
    }

    @Override // tj3.a
    public void J(j reserveItem, com.tencent.mobileqq.zootopia.api.e<qv4.b> callback) {
        Intrinsics.checkNotNullParameter(reserveItem, "reserveItem");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ReservationImpl", 1, "cancelReservation reserveItem:" + reserveItem);
        qv4.a aVar = new qv4.a();
        aVar.f429883a = new j[]{reserveItem};
        uj3.a.b(uj3.a.f439091a, aVar, new b(reserveItem, callback), 0, 4, null);
    }

    @Override // tj3.a
    public void R(j item, com.tencent.mobileqq.zootopia.api.e<ay> callback) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ReservationImpl", 1, "modifyReserveConfig");
        ax axVar = new ax();
        axVar.f430023a = item;
        uj3.a.f(uj3.a.f439091a, axVar, new d(callback, item), 0, 4, null);
    }

    @Override // tj3.a
    public void i(int reservationType, int reserveStatus, com.tencent.mobileqq.zootopia.api.e<ad> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ReservationImpl", 1, IZplanHandleApi.METHOD_REFRESH_RESERVE);
        ac acVar = new ac();
        acVar.f429900a = reservationType;
        acVar.f429901b = reserveStatus;
        uj3.a.d(uj3.a.f439091a, acVar, new e(callback), 0, 4, null);
    }

    @Override // tj3.a
    public j o(String reserveId, int reserveType) {
        j[] jVarArr;
        Intrinsics.checkNotNullParameter(reserveId, "reserveId");
        ad value = k1().getValue();
        if (value == null || (jVarArr = value.f429902a) == null) {
            return null;
        }
        for (j jVar : jVarArr) {
            if (Intrinsics.areEqual(jVar.f427619b, reserveId) && jVar.f427618a == reserveType) {
                return jVar;
            }
        }
        return null;
    }

    @Override // tj3.a
    public MutableLiveData<ad> r0() {
        return k1();
    }

    @Override // tj3.a
    public void s0(j reserveItem, boolean needRemind, com.tencent.mobileqq.zootopia.api.e<bf> callback) {
        Intrinsics.checkNotNullParameter(reserveItem, "reserveItem");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ReservationImpl", 1, "reservation reserveItem:" + reserveItem + " needRemind:" + needRemind);
        be beVar = new be();
        beVar.f430055a = new j[]{reserveItem};
        uj3.a.h(uj3.a.f439091a, beVar, new f(reserveItem, needRemind, callback), 0, 4, null);
    }

    @Override // tj3.a
    public void u0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("ReservationImpl", 1, "openReservationPage");
        QPublicFragmentActivity.start(context, ReservationManageFragment.class);
    }

    public void y1(int reserveType, String reserveId, k reserveItemConfig) {
        j[] jVarArr;
        k kVar;
        j jVar;
        Intrinsics.checkNotNullParameter(reserveId, "reserveId");
        Intrinsics.checkNotNullParameter(reserveItemConfig, "reserveItemConfig");
        QLog.i("ReservationImpl", 1, "updateReserveConfig reserveType:" + reserveType + " reserveId:" + reserveId + " reserveItemConfig:" + reserveItemConfig);
        ad value = k1().getValue();
        if (value == null || (jVarArr = value.f429902a) == null) {
            return;
        }
        int length = jVarArr.length;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            kVar = null;
            if (i16 >= length) {
                jVar = null;
                break;
            }
            jVar = jVarArr[i16];
            if (Intrinsics.areEqual(jVar.f427619b, reserveId) && jVar.f427618a == reserveType) {
                break;
            } else {
                i16++;
            }
        }
        if (jVar != null) {
            k[] kVarArr = jVar.f427623f;
            Intrinsics.checkNotNullExpressionValue(kVarArr, "it.configList");
            int length2 = kVarArr.length;
            while (true) {
                if (i3 >= length2) {
                    break;
                }
                k config = kVarArr[i3];
                Intrinsics.checkNotNullExpressionValue(config, "config");
                if (com.tencent.mobileqq.zootopia.utils.g.c(config, reserveItemConfig)) {
                    kVar = config;
                    break;
                }
                i3++;
            }
            if (kVar != null) {
                kVar.f427628d = reserveItemConfig.f427628d;
                ad value2 = k1().getValue();
                if (value2 != null) {
                    k1().postValue(value2);
                    x1(value2);
                    ((si3.b) vb3.a.f441346a.a(si3.b.class)).Q("wifi config change", true);
                }
            }
        }
    }

    public void z1(int reserveType, String reserveId, boolean reserved) {
        j[] jVarArr;
        j jVar;
        Intrinsics.checkNotNullParameter(reserveId, "reserveId");
        QLog.i("ReservationImpl", 1, "updateReserveStatus reserveType:" + reserveType + " reserveId:" + reserveId + " reserved:" + reserved);
        ad value = k1().getValue();
        if (value == null || (jVarArr = value.f429902a) == null) {
            return;
        }
        int length = jVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                jVar = null;
                break;
            }
            jVar = jVarArr[i3];
            if (jVar.f427618a == reserveType && Intrinsics.areEqual(jVar.f427619b, reserveId)) {
                break;
            } else {
                i3++;
            }
        }
        if (jVar != null) {
            jVar.f427620c = reserved;
            ad value2 = k1().getValue();
            if (value2 != null) {
                QLog.i("ReservationImpl", 1, "updateReserveStatus succ");
                k1().postValue(value2);
                x1(value2);
            }
        }
    }

    private final Map<String, Object> j1(int mapId) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_id", Integer.valueOf(mapId)), new Pair("zplan_module_id", "em_zplan_playground_gallery_infocard"));
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(Switch switchWifi, boolean isChecked, j reserveItem) {
        switchWifi.setOnCheckedChangeListener(null);
        switchWifi.setChecked(!isChecked);
        switchWifi.setOnCheckedChangeListener(l1(switchWifi, reserveItem));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x1(ad value) {
        QLog.i("ReservationImpl", 1, "updateDbCache");
        ZplanDataBaseHelper.h().c(ReserveListEntity.class.getSimpleName());
        return ZplanDataBaseHelper.h().i(ReserveListEntity.INSTANCE.a(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(j reserveItem, boolean isSuccess) {
        String str;
        Map<String, Object> mutableMapOf;
        if (isSuccess) {
            str = "ev_zplan_mod_reserve_success";
        } else {
            str = "ev_zplan_mod_reserve_fail";
        }
        if (com.tencent.mobileqq.zootopia.utils.g.h(reserveItem)) {
            com.tencent.sqshow.zootopia.report.a aVar = com.tencent.sqshow.zootopia.report.a.f372690a;
            String str2 = reserveItem.f427619b;
            Intrinsics.checkNotNullExpressionValue(str2, "reserveItem.id");
            HashMap<String, Object> d16 = aVar.d(Integer.parseInt(str2), true);
            d16.put("zplan_reserver_type", Integer.valueOf(reserveItem.f427618a));
            String str3 = reserveItem.f427619b;
            Intrinsics.checkNotNullExpressionValue(str3, "reserveItem.id");
            d16.put("zplan_reserver_id", str3);
            id3.d dVar = this.dtReportHelper;
            if (dVar != null) {
                String str4 = reserveItem.f427619b;
                Intrinsics.checkNotNullExpressionValue(str4, "reserveItem.id");
                Map<String, Object> j16 = j1(Integer.parseInt(str4));
                if (d16.size() > 0) {
                    j16.putAll(d16);
                }
                Unit unit = Unit.INSTANCE;
                dVar.d(str, j16);
                return;
            }
            return;
        }
        id3.d dVar2 = this.dtReportHelper;
        if (dVar2 != null) {
            String str5 = reserveItem.f427619b;
            Intrinsics.checkNotNullExpressionValue(str5, "reserveItem.id");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_reserver_type", Integer.valueOf(reserveItem.f427618a)), new Pair("zplan_reserver_id", str5));
            dVar2.d(str, mutableMapOf);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/ReservationImpl$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ay;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ay> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ j f335082e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f335083f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Switch f335084h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f335085i;

        c(j jVar, k kVar, Switch r46, boolean z16) {
            this.f335082e = jVar;
            this.f335083f = kVar;
            this.f335084h = r46;
            this.f335085i = z16;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ay result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QQToastUtil.showQQToast(2, result.f430024a);
            ReservationImpl reservationImpl = ReservationImpl.this;
            j jVar = this.f335082e;
            int i3 = jVar.f427618a;
            String str = jVar.f427619b;
            Intrinsics.checkNotNullExpressionValue(str, "reserveItem.id");
            reservationImpl.y1(i3, str, this.f335083f);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToastUtil.showQQToast(1, R.string.xbo);
            ReservationImpl.this.u1(this.f335084h, this.f335085i, this.f335082e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(Bundle bundle, Bundle bundle2) {
        QLog.i("ReservationImpl", 1, "\u9759\u9ed8\u8ba2\u9605\u7ed3\u679c retcode:" + (bundle != null ? Integer.valueOf(bundle.getInt("retcode")) : null) + " retmsg:" + (bundle != null ? bundle.getString("retmsg") : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(final j reserveItem, final ReservationImpl this$0, final Switch switchWifi, CompoundButton compoundButton, final boolean z16) {
        final k kVar;
        Intrinsics.checkNotNullParameter(reserveItem, "$reserveItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchWifi, "$switchWifi");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.b3j);
            return;
        }
        k[] kVarArr = reserveItem.f427623f;
        if (kVarArr != null) {
            int length = kVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    kVar = null;
                    break;
                }
                k it = kVarArr[i3];
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (com.tencent.mobileqq.zootopia.utils.g.j(it)) {
                    kVar = it;
                    break;
                }
                i3++;
            }
            if (kVar != null) {
                if (!z16) {
                    DialogUtil.createNoTitleDialog(Foreground.getTopActivity(), kVar.f427629e, R.string.xbb, R.string.xbc, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.reservation.impl.f
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            ReservationImpl.n1(ReservationImpl.this, kVar, z16, reserveItem, switchWifi, dialogInterface, i16);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.reservation.impl.g
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            ReservationImpl.o1(ReservationImpl.this, switchWifi, z16, reserveItem, dialogInterface, i16);
                        }
                    }).show();
                } else {
                    this$0.p1(kVar, z16, reserveItem, switchWifi);
                }
            }
        }
    }
}
