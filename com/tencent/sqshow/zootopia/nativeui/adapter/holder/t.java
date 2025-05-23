package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b94.e;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PanelSubTitlePageDataRepo;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.actionsheet.AvatarActionSheetDialogView;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.util.QQToastUtil;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k94.AvatarTemplateNeedUpdateData;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l94.e;
import uv4.az;
import uv4.bk;
import uv4.bt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001[\b\u0016\u0018\u0000 72\u00020\u0001:\u0001cB\u001f\u0012\u0006\u0010C\u001a\u00020>\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010G\u001a\u00020D\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\"\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J%\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020&H\u0016J\u0016\u0010*\u001a\u00020\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0(H\u0014J\b\u0010+\u001a\u00020\u0002H\u0014J\b\u0010,\u001a\u00020\u0002H\u0014J\b\u0010.\u001a\u00020-H\u0004J\u0010\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010(H\u0014J2\u00107\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u001b2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020104j\b\u0012\u0004\u0012\u000201`5H\u0016J\u0010\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001bH\u0016J\b\u0010:\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u00020\u0002H\u0016J\b\u0010<\u001a\u00020\u001fH\u0016J\b\u0010=\u001a\u00020-H\u0016R\u0017\u0010C\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\"\u0010M\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010NR\"\u0010Z\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010H\u001a\u0004\bX\u0010J\"\u0004\bY\u0010LR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006d"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/t;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "", "k1", "Z0", "", "remainTimeMills", "w1", "Y0", "remainSecond", "l1", "o1", "m1", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "recordResult", ICustomDataEditor.NUMBER_PARAM_1, "t1", "e1", "Luv4/ag;", "outfitCfg", "x1", "p1", "b1", "y1", "j1", "Landroid/content/Context;", "context", "", "fixedPosInList", "r1", "", "", "conflictTips", "u1", "([Ljava/lang/String;Luv4/ag;)V", "message", "defaultMsgId", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "O", "", "idList", "i0", HippyTKDListViewAdapter.X, "v", "", "f1", "Luv4/az;", BdhLogUtil.LogTag.Tag_Req, "Luv4/bk;", "data", "posInList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "totalData", "e0", "id", "X0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "q0", "J0", "Y", "Ln74/s;", "W", "Ln74/s;", "c1", "()Ln74/s;", "binding", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "X", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "panelSubTitlePageDataRepo", "I", "d1", "()I", "setOriginalPosInList", "(I)V", "originalPosInList", "Z", "Ljava/lang/String;", "expiredString", "Landroid/os/CountDownTimer;", "a0", "Landroid/os/CountDownTimer;", "exipreTimeCountDownTimer", "b0", "handleDressChangeNotify", "c0", "getRedDotId", "setRedDotId", "redDotId", "com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$c", "d0", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/t$c;", "recordListener", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "commonData", "<init>", "(Ln74/s;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class t extends BaseAvatarPanelItemViewHolder {

    /* renamed from: W, reason: from kotlin metadata */
    private final n74.s binding;

    /* renamed from: X, reason: from kotlin metadata */
    private final PanelSubTitlePageDataRepo panelSubTitlePageDataRepo;

    /* renamed from: Y, reason: from kotlin metadata */
    private int originalPosInList;

    /* renamed from: Z, reason: from kotlin metadata */
    private final String expiredString;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer exipreTimeCountDownTimer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean handleDressChangeNotify;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int redDotId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final c recordListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/l;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<uv4.l> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.l result) {
            Intrinsics.checkNotNullParameter(result, "result");
            t.this.j1();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            t.this.e1();
            t.this.s1(message, R.string.xrk);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$c", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/DressUpItemRecordHelper$a;", "", "dressKey", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "recordResult", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements DressUpItemRecordHelper.a {
        c() {
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper.a
        public void a(String dressKey, ZPlanRecordResource recordResult) {
            Intrinsics.checkNotNullParameter(dressKey, "dressKey");
            t.this.b0("recordListener#Finish, dressKey= " + dressKey + ", " + recordResult);
            t.this.n1(recordResult);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<uv4.aa> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f370898e;

        d(long j3) {
            this.f370898e = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.aa result) {
            Intrinsics.checkNotNullParameter(result, "result");
            t tVar = t.this;
            tVar.b0("refreshListData#onResultSuccess - " + tVar.getOriginalPosInList() + ", costTime = " + (System.currentTimeMillis() - this.f370898e));
            t.this.e1();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            t tVar = t.this;
            tVar.a0("refreshListData#onResultFailure - " + tVar.getOriginalPosInList() + ", costTime = " + (System.currentTimeMillis() - this.f370898e));
            t.this.e1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bt;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<bt> {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
        
            r6 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r6);
         */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(bt result) {
            List<az> emptyList;
            az[] azVarArr;
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = result.f440391a;
            if (i3 == 0) {
                t.this.j1();
                return;
            }
            t.this.a0("saveAvatarTemplate exception, error = " + i3 + " - " + result.f440392b);
            t.this.e1();
            t.this.s1(result.f440392b, R.string.xrq);
            uv4.al alVar = result.f440393c;
            if (((alVar == null || (azVarArr = alVar.f440153b) == null) ? 0 : azVarArr.length) > 0) {
                t tVar = t.this;
                qu4.a aVar = alVar != null ? alVar.f440152a : null;
                if (aVar == null) {
                    aVar = new qu4.a();
                }
                uv4.al alVar2 = result.f440393c;
                if (alVar2 == null || (r6 = alVar2.f440153b) == null || emptyList == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                tVar.C(aVar, emptyList);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            t.this.e1();
            t.this.s1(message, R.string.xrq);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$f", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements l94.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f370901b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ uv4.ag f370902c;

        f(int i3, uv4.ag agVar) {
            this.f370901b = i3;
            this.f370902c = agVar;
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            t.this.b0("showContextMenu#onItemClick - tryOn, posInList = " + this.f370901b);
            ZplanViewReportHelper.f(t.this.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter(), view, "em_zplan_suit_change", null, 4, null);
            t.this.x1(this.f370902c);
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$g", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements l94.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f370904b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ uv4.ag f370905c;

        g(int i3, uv4.ag agVar) {
            this.f370904b = i3;
            this.f370905c = agVar;
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            t.this.b0("showContextMenu#onItemClick - delete, posInList = " + this.f370904b);
            ZplanViewReportHelper.f(t.this.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter(), view, "em_zplan_suit_delete", null, 4, null);
            t.this.b1(this.f370905c);
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$h", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements l94.e {
        h() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$i", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f370906a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j3, t tVar) {
            super(j3, 1000L);
            this.f370906a = tVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f370906a.l1(-1L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            this.f370906a.l1(millisUntilFinished / 1000);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/t$j", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bt;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class j implements com.tencent.mobileqq.zootopia.api.e<bt> {
        j() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        
            r2 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r2);
         */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(bt result) {
            List<az> emptyList;
            az[] azVarArr;
            Intrinsics.checkNotNullParameter(result, "result");
            uv4.al alVar = result.f440393c;
            if (((alVar == null || (azVarArr = alVar.f440153b) == null) ? 0 : azVarArr.length) > 0) {
                t tVar = t.this;
                qu4.a aVar = alVar != null ? alVar.f440152a : null;
                if (aVar == null) {
                    aVar = new qu4.a();
                }
                uv4.al alVar2 = result.f440393c;
                if (alVar2 == null || (r2 = alVar2.f440153b) == null || emptyList == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                tVar.C(aVar, emptyList);
            }
            int i3 = result.f440391a;
            if (i3 == 0) {
                t.this.j1();
                return;
            }
            t.this.a0("updateAvatarTemplate exception, error = " + i3 + " - " + result.f440392b);
            t.this.s1(result.f440392b, R.string.xrr);
            t.this.e1();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            t.this.e1();
            t.this.s1(message, R.string.xrr);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public t(n74.s binding, com.tencent.sqshow.zootopia.nativeui.data.j commonData, PanelSubTitlePageDataRepo panelSubTitlePageDataRepo) {
        super(r0, commonData);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(commonData, "commonData");
        Intrinsics.checkNotNullParameter(panelSubTitlePageDataRepo, "panelSubTitlePageDataRepo");
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.binding = binding;
        this.panelSubTitlePageDataRepo = panelSubTitlePageDataRepo;
        this.originalPosInList = -1;
        String string = BaseApplication.context.getResources().getString(R.string.xrl);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026tiveui_shop_item_expired)");
        this.expiredString = string;
        this.handleDressChangeNotify = true;
        TextView textView = binding.f419407f;
        t74.m mVar = t74.m.f435564a;
        AssetManager assets = binding.getRoot().getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "binding.root.context.assets");
        textView.setTypeface(mVar.b(assets));
        this.recordListener = new c();
    }

    private final void Y0() {
        CountDownTimer countDownTimer = this.exipreTimeCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.exipreTimeCountDownTimer = null;
    }

    private final void Z0() {
        uv4.ag agVar;
        uv4.al alVar;
        az[] azVarArr;
        bk bindingData = getBindingData();
        az azVar = null;
        Object obj = null;
        azVar = null;
        azVar = null;
        azVar = null;
        if (bindingData != null && (agVar = bindingData.f440367c) != null && (alVar = agVar.f440133d) != null && (azVarArr = alVar.f440153b) != null) {
            ArrayList arrayList = new ArrayList();
            for (az azVar2 : azVarArr) {
                if (azVar2.A > 0) {
                    arrayList.add(azVar2);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    int i3 = ((az) obj).A;
                    do {
                        Object next = it.next();
                        int i16 = ((az) next).A;
                        if (i3 > i16) {
                            obj = next;
                            i3 = i16;
                        }
                    } while (it.hasNext());
                }
            }
            azVar = (az) obj;
        }
        if (azVar == null) {
            this.binding.f419409h.setVisibility(8);
            this.binding.f419409h.setText("");
            return;
        }
        this.binding.f419409h.setVisibility(0);
        long serverTimeMillis = azVar.A - (NetConnInfoCenter.getServerTimeMillis() / 1000);
        if (serverTimeMillis <= 0) {
            this.binding.f419409h.setText(this.expiredString);
            return;
        }
        l1(serverTimeMillis);
        if (serverTimeMillis <= 86400) {
            w1(serverTimeMillis * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        b94.e O = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().O();
        if (O != null) {
            O.S2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(t this$0, String reportElementId, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportElementId, "$reportElementId");
        ZplanViewReportHelper mReporter = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        FrameLayout root = this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mReporter.g(root, reportElementId, (r16 & 4) != 0 ? null : map, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h1(boolean z16, t this$0, int i3, bk bkVar, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            return true;
        }
        this$0.b0("onLongClick, posInList= " + i3);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.r1(context, bkVar.f440367c, i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(t this$0, boolean z16, String reportElementId, Map map, bk bkVar, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportElementId, "$reportElementId");
        if (u.a.a(this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getUeStatusController(), false, 1, null)) {
            this$0.b0("clickItem - " + z16);
            ZplanViewReportHelper mReporter = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mReporter.e(it, reportElementId, map);
            this$0.a1();
            if (this$0.f1()) {
                this$0.p1();
            } else {
                this$0.x1(bkVar.f440367c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        b0("post refreshListData, " + this.originalPosInList + " - " + this.itemView);
        this.panelSubTitlePageDataRepo.s(new d(System.currentTimeMillis()));
    }

    private final void k1() {
        uv4.ag agVar;
        uv4.al alVar;
        qu4.a aVar;
        if (getBindingData() != null) {
            if (f1()) {
                this.binding.f419403b.setVisibility(0);
                return;
            }
            m94.a b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b();
            bk bindingData = getBindingData();
            if ((bindingData == null || (agVar = bindingData.f440367c) == null || (alVar = agVar.f440133d) == null || (aVar = alVar.f440152a) == null) ? false : r94.a.c(aVar, b16.getAvatarCharacter())) {
                this.binding.f419403b.setVisibility(0);
            } else {
                this.binding.f419403b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(long remainSecond) {
        String string;
        String c16 = com.tencent.sqshow.zootopia.utils.t.f373300a.c(remainSecond);
        if (remainSecond <= 0) {
            string = this.expiredString;
        } else {
            string = this.binding.getRoot().getContext().getString(R.string.xlj, c16);
            Intrinsics.checkNotNullExpressionValue(string, "binding.root.context.get\u2026ountdownTimeTxt\n        )");
        }
        if (remainSecond <= 0) {
            this.binding.f419409h.setText(string);
        } else {
            TextView textView = this.binding.f419409h;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.dressupContentValidTime");
            m84.b.i(textView, string, this.binding.getRoot().getContext().getResources().getColor(R.color.qui_common_text_primary), 0, c16.length());
        }
        this.binding.f419409h.setVisibility(0);
    }

    private final void m1() {
        this.binding.f419411j.setImageResource(R.drawable.h4b);
    }

    private final void o1() {
        this.binding.f419411j.setImageResource(R.drawable.h4b);
    }

    private final void p1() {
        ga4.g a16;
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        m94.a b16 = cVar.m().b();
        if (!cVar.t(getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getStoreItemPool()).isEmpty()) {
            ga4.j jVar = ga4.j.f401682a;
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String();
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            a16 = jVar.a(22, jVar2, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
            a16.show();
            return;
        }
        t1();
        com.tencent.sqshow.zootopia.nativeui.data.repo.d.f371092a.c(this.originalPosInList, b16.getAvatarCharacter(), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(String message, int defaultMsgId) {
        if (TextUtils.isEmpty(message)) {
            QQToastUtil.showQQToast(1, defaultMsgId);
        } else {
            QQToastUtil.showQQToast(1, message);
        }
    }

    private final void t1() {
        b94.e O = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().O();
        if (O != null) {
            O.P1(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(t this$0, uv4.ag outfitCfg, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(outfitCfg, "$outfitCfg");
        this$0.y1(outfitCfg);
    }

    private final void w1(long remainTimeMills) {
        if (this.exipreTimeCountDownTimer == null) {
            i iVar = new i(remainTimeMills, this);
            getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().I().add(iVar);
            this.exipreTimeCountDownTimer = iVar;
        }
        CountDownTimer countDownTimer = this.exipreTimeCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r5 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x1(uv4.ag outfitCfg) {
        List<az> emptyList;
        az[] items;
        getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().k().setValue(getBindingData());
        Unit unit = null;
        if (outfitCfg != null) {
            String[] strArr = outfitCfg.f440135f;
            if ((strArr != null ? strArr.length : 0) > 0) {
                if (strArr == null) {
                    strArr = new String[0];
                } else {
                    Intrinsics.checkNotNullExpressionValue(strArr, "it.conflictTips ?: arrayOf()");
                }
                u1(strArr, outfitCfg);
            } else {
                uv4.al alVar = outfitCfg.f440133d;
                qu4.a aVar = alVar != null ? alVar.f440152a : null;
                if (aVar == null) {
                    aVar = new qu4.a();
                } else {
                    Intrinsics.checkNotNullExpressionValue(aVar, "it.avatar?.avatarCharacter ?: AvatarCharacter()");
                }
                uv4.al alVar2 = outfitCfg.f440133d;
                if (alVar2 != null && (items = alVar2.f440153b) != null) {
                    Intrinsics.checkNotNullExpressionValue(items, "items");
                    emptyList = ArraysKt___ArraysJvmKt.asList(items);
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                C(aVar, emptyList);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            s1("", R.string.xrt);
        }
    }

    private final void y1(uv4.ag outfitCfg) {
        b0("click updateAvatarTemplate - " + outfitCfg.f440131b);
        t1();
        com.tencent.sqshow.zootopia.nativeui.data.repo.d.f371092a.d(this.originalPosInList, outfitCfg, new j());
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public String J0() {
        return "DressUpItemViewHolder_";
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public NativePanelLoadingIgv O() {
        NativePanelLoadingIgv nativePanelLoadingIgv = this.binding.f419410i;
        Intrinsics.checkNotNullExpressionValue(nativePanelLoadingIgv, "binding.loadingCircleView");
        return nativePanelLoadingIgv;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r0);
     */
    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected List<az> R() {
        uv4.ag agVar;
        uv4.al alVar;
        List<az> asList;
        bk bindingData = getBindingData();
        if (bindingData == null || (agVar = bindingData.f440367c) == null || (alVar = agVar.f440133d) == null || (r0 = alVar.f440153b) == null || asList == null) {
            return null;
        }
        return asList;
    }

    public void X0(int id5) {
        this.binding.f419412k.g(1);
        this.binding.f419412k.h(id5);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public boolean Y() {
        qu4.q[] qVarArr;
        qu4.q[] qVarArr2;
        uv4.ag agVar;
        uv4.al alVar;
        bk bindingData = getBindingData();
        qu4.a aVar = (bindingData == null || (agVar = bindingData.f440367c) == null || (alVar = agVar.f440133d) == null) ? null : alVar.f440152a;
        if (aVar == null) {
            return false;
        }
        ArrayList<qu4.q> arrayList = new ArrayList();
        qu4.b bVar = aVar.f429572a;
        if (bVar != null && (qVarArr2 = bVar.f429578b) != null) {
            for (qu4.q it : qVarArr2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
            }
        }
        qu4.m mVar = aVar.f429574c;
        if (mVar != null && (qVarArr = mVar.f429621b) != null) {
            for (qu4.q it5 : qVarArr) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.add(it5);
            }
        }
        for (qu4.q qVar : arrayList) {
            if (qVar.f429639a != AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_MAKEUP.getValue() && qVar.f429639a != AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_BODY.getValue()) {
                FilamentUrlTemplate a16 = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getEngineApi().a();
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                if (!FilamentFileUtil.INSTANCE.fileExistsAtPath(zPlanAvatarResourceHelper.N0(zPlanAvatarResourceHelper.p0(qVar.f429639a, qVar.f429640b, a16), a16))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void a1() {
        g94.f.b(g94.f.f401577a, this.redDotId, this.binding.f419412k.getStoreType(), 0, true, 4, null);
    }

    /* renamed from: c1, reason: from getter */
    public final n74.s getBinding() {
        return this.binding;
    }

    /* renamed from: d1, reason: from getter */
    public final int getOriginalPosInList() {
        return this.originalPosInList;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void e0(final bk data, int posInList, ArrayList<bk> totalData) {
        Object firstOrNull;
        String str;
        final LinkedHashMap linkedHashMap;
        String str2;
        uv4.al alVar;
        uv4.al alVar2;
        String[] strArr;
        Intrinsics.checkNotNullParameter(totalData, "totalData");
        if (data == null) {
            return;
        }
        D0(data);
        QLog.i("DressUpItemViewHolder_", 1, "onBindData posInList:" + posInList);
        this.originalPosInList = posInList;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) totalData);
        bk bkVar = (bk) firstOrNull;
        final int i3 = bkVar != null && bkVar.f440365a == 3 ? posInList - 1 : posInList;
        az azVar = data.f440366b;
        int i16 = azVar != null ? azVar.D : 0;
        this.redDotId = i16;
        X0(i16);
        final boolean f16 = f1();
        if (f16) {
            str = "em_zplan_suit_save";
        } else {
            str = "em_zplan_suit";
        }
        final String str3 = str;
        if (f16) {
            linkedHashMap = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("zplan_suit_pos", String.valueOf(posInList));
            linkedHashMap = linkedHashMap2;
        }
        this.binding.getRoot().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.p
            @Override // java.lang.Runnable
            public final void run() {
                t.g1(t.this, str3, linkedHashMap);
            }
        });
        if (J()) {
            this.binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.q
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean h16;
                    h16 = t.h1(f16, this, i3, data, view);
                    return h16;
                }
            });
        }
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        com.tencent.sqshow.zootopia.utils.aa.f(root, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.i1(t.this, f16, str3, linkedHashMap, data, view);
            }
        }, 1000L, String.valueOf(this.itemView.hashCode()));
        k1();
        Y0();
        DressUpItemRecordHelper dressUpItemRecordHelper = DressUpItemRecordHelper.f370779a;
        dressUpItemRecordHelper.o(this.recordListener);
        str2 = "";
        if (!f16) {
            this.binding.f419404c.setVisibility(8);
            TextView textView = this.binding.f419408g;
            uv4.ag agVar = data.f440367c;
            textView.setVisibility(((agVar == null || (strArr = agVar.f440135f) == null) ? 0 : strArr.length) > 0 ? 0 : 8);
            Z0();
            this.binding.f419411j.setVisibility(0);
            uv4.ag agVar2 = data.f440367c;
            if (TextUtils.isEmpty(agVar2 != null ? agVar2.f440132c : null)) {
                uv4.ag agVar3 = data.f440367c;
                String str4 = (agVar3 == null || (alVar2 = agVar3.f440133d) == null) ? null : alVar2.f440155d;
                if (str4 == null) {
                    str4 = "";
                }
                dressUpItemRecordHelper.k(str4, this.recordListener);
                uv4.ag agVar4 = data.f440367c;
                if (agVar4 != null && (alVar = agVar4.f440133d) != null) {
                    r8 = alVar.f440155d;
                }
                if (!dressUpItemRecordHelper.i(r8 != null ? r8 : "")) {
                    if (dressUpItemRecordHelper.n(data.f440367c, this.originalPosInList)) {
                        o1();
                        return;
                    } else {
                        m1();
                        return;
                    }
                }
                b0("onBindData already recording - " + this.originalPosInList);
                o1();
                return;
            }
            RoundCornerImageView roundCornerImageView = this.binding.f419411j;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.mainImg");
            uv4.ag agVar5 = data.f440367c;
            r8 = agVar5 != null ? agVar5.f440132c : null;
            CommonExKt.w(roundCornerImageView, r8 == null ? "" : r8, com.tencent.sqshow.zootopia.utils.q.b(R.drawable.h4b), null, 4, null);
            return;
        }
        this.binding.f419411j.setVisibility(8);
        this.binding.f419408g.setVisibility(8);
        this.binding.f419409h.setVisibility(8);
        this.binding.f419403b.setElevation(0.0f);
        this.binding.f419403b.setVisibility(0);
        this.binding.f419403b.setImageResource(R.drawable.h4c);
        this.binding.f419404c.setVisibility(0);
        TextView textView2 = this.binding.f419407f;
        uv4.a aVar = data.f440368d;
        if (aVar != null) {
            str2 = aVar.f440101a + "/" + aVar.f440102b;
        }
        textView2.setText(str2);
        this.binding.f419406e.setImageDrawable(ie0.a.f().o(this.binding.f419404c.getContext(), R.drawable.iee, R.color.qui_common_icon_primary, 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f1() {
        bk bindingData = getBindingData();
        return bindingData != null && bindingData.f440365a == 3;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    protected void i0(List<String> idList) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        super.i0(idList);
        if (this.handleDressChangeNotify) {
            k1();
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void q0() {
        super.q0();
        a1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void v() {
        this.handleDressChangeNotify = true;
        b94.e O = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().O();
        if (O != null) {
            O.S2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void x() {
        this.handleDressChangeNotify = false;
        b94.e O = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().O();
        if (O != null) {
            e.a.h(O, 0L, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(uv4.ag outfitCfg) {
        if (outfitCfg != null) {
            getBindingData();
            t1();
            com.tencent.sqshow.zootopia.nativeui.data.repo.d.f371092a.a(this.originalPosInList, outfitCfg, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(ZPlanRecordResource recordResult) {
        if (recordResult == null) {
            m1();
            return;
        }
        URLDrawable.URLDrawableOptions option = URLDrawable.URLDrawableOptions.obtain();
        option.mRequestWidth = this.binding.f419411j.getWidth();
        option.mRequestHeight = this.binding.f419411j.getHeight();
        option.mLoadingDrawable = new ColorDrawable(0);
        option.mUseSharpPAnimImage = true;
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_double_bitmap", true);
        option.mExtraInfo = bundle;
        if (recordResult.o()) {
            this.binding.f419411j.setImageDrawable(URLDrawable.getFileDrawable(recordResult.getLocalPath(), option));
            return;
        }
        if (recordResult.p()) {
            RoundCornerImageView roundCornerImageView = this.binding.f419411j;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.mainImg");
            String remoteUrl = recordResult.getRemoteUrl();
            if (remoteUrl == null) {
                remoteUrl = "";
            }
            Intrinsics.checkNotNullExpressionValue(option, "option");
            CommonExKt.u(roundCornerImageView, remoteUrl, option, null);
            return;
        }
        a0("DressUpItemViewHolder_DressUpItemRecordHelper onRecordRes invalid res");
        m1();
    }

    private final void u1(String[] conflictTips, final uv4.ag outfitCfg) {
        List list;
        ga4.g a16;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.v1(t.this, outfitCfg, view);
            }
        };
        ga4.j jVar2 = ga4.j.f401682a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        list = ArraysKt___ArraysKt.toList(conflictTips);
        a16 = jVar2.a(18, jVar, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, null, null, new AvatarTemplateNeedUpdateData(list, outfitCfg.f440130a, onClickListener, null, 8, null), 0, 47, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    private final void r1(Context context, uv4.ag outfitCfg, int fixedPosInList) {
        l94.a aVar = new l94.a();
        String string = context.getResources().getString(R.string.xr9);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026op_avatar_template_tryon)");
        l94.a a16 = aVar.a(0, string, false, new f(fixedPosInList, outfitCfg));
        String string2 = context.getResources().getString(R.string.xr7);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026p_avatar_template_delete)");
        ga4.g m3 = NativeUiDialogUtils.f371177a.m(getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String(), context, a16.a(1, string2, true, new g(fixedPosInList, outfitCfg)).d(new h()));
        AvatarActionSheetDialogView avatarActionSheetDialogView = m3 instanceof AvatarActionSheetDialogView ? (AvatarActionSheetDialogView) m3 : null;
        if (avatarActionSheetDialogView != null) {
            View P = avatarActionSheetDialogView.P(0);
            if (P != null) {
                getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter().g(P, "em_zplan_suit_change", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
            View P2 = avatarActionSheetDialogView.P(1);
            if (P2 != null) {
                getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter().g(P2, "em_zplan_suit_delete", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }
    }
}
