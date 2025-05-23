package com.tencent.mobileqq.guild.home.views.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0001\rBm\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0010\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u001e\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0019\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R,\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R#\u00104\u001a\n 1*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/dialog/SingleOptionPopupWindow;", "", "Landroid/widget/PopupWindow;", "k", "", "initialSelected", "Landroid/view/View;", "anchor", "", "o", DomainData.DOMAIN_NAME, "p", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "", "", "b", "Ljava/util/Map;", "itemValueMap", "c", "itemReportMap", "d", "extraDtParams", "Lkotlin/Function3;", "e", "Lkotlin/jvm/functions/Function3;", "itemClickListener", "f", "Landroid/widget/PopupWindow;", "popupWindow", "Landroid/widget/ListView;", "g", "Landroid/widget/ListView;", "listView", "", h.F, "[Ljava/lang/Integer;", "itemKeys", "i", "[Ljava/lang/String;", "itemValues", "Lcom/tencent/mobileqq/guild/home/views/dialog/c;", "j", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/guild/home/views/dialog/c;", "arrayAdapter", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "popupView", "<init>", "(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SingleOptionPopupWindow {

    /* renamed from: m, reason: collision with root package name */
    private static final int f225560m = (int) cw.c(8.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, String> itemValueMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> itemReportMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> extraDtParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<Integer, Integer, String, Unit> itemClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ListView listView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Integer[] itemKeys;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] itemValues;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy arrayAdapter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupView;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleOptionPopupWindow(@NotNull Context context, @NotNull Map<Integer, String> itemValueMap, @NotNull Map<Integer, Integer> itemReportMap, @NotNull Map<String, ? extends Object> extraDtParams, @NotNull Function3<? super Integer, ? super Integer, ? super String, Unit> itemClickListener) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemValueMap, "itemValueMap");
        Intrinsics.checkNotNullParameter(itemReportMap, "itemReportMap");
        Intrinsics.checkNotNullParameter(extraDtParams, "extraDtParams");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.context = context;
        this.itemValueMap = itemValueMap;
        this.itemReportMap = itemReportMap;
        this.extraDtParams = extraDtParams;
        this.itemClickListener = itemClickListener;
        Object[] array = itemValueMap.keySet().toArray(new Integer[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.itemKeys = (Integer[]) array;
        Object[] array2 = itemValueMap.values().toArray(new String[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.itemValues = (String[]) array2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.home.views.dialog.SingleOptionPopupWindow$arrayAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                Context context2;
                Integer[] numArr;
                String[] strArr;
                Map map;
                Map map2;
                context2 = SingleOptionPopupWindow.this.context;
                numArr = SingleOptionPopupWindow.this.itemKeys;
                strArr = SingleOptionPopupWindow.this.itemValues;
                map = SingleOptionPopupWindow.this.itemReportMap;
                map2 = SingleOptionPopupWindow.this.extraDtParams;
                final SingleOptionPopupWindow singleOptionPopupWindow = SingleOptionPopupWindow.this;
                return new c(context2, R.layout.evd, numArr, strArr, map, -1, map2, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.dialog.SingleOptionPopupWindow$arrayAdapter$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        Integer[] numArr2;
                        String[] strArr2;
                        Function3 function3;
                        PopupWindow popupWindow;
                        numArr2 = SingleOptionPopupWindow.this.itemKeys;
                        int intValue = numArr2[i3].intValue();
                        strArr2 = SingleOptionPopupWindow.this.itemValues;
                        String str = strArr2[i3];
                        function3 = SingleOptionPopupWindow.this.itemClickListener;
                        function3.invoke(Integer.valueOf(i3), Integer.valueOf(intValue), str);
                        popupWindow = SingleOptionPopupWindow.this.popupWindow;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        }
                    }
                });
            }
        });
        this.arrayAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new SingleOptionPopupWindow$popupView$2(this));
        this.popupView = lazy2;
    }

    private final PopupWindow k() {
        return new PopupWindow(m(), -2, -2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c l() {
        return (c) this.arrayAdapter.getValue();
    }

    private final View m() {
        return (View) this.popupView.getValue();
    }

    private final int n() {
        int paddingTop = m().getPaddingTop();
        ListView listView = this.listView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        return -(paddingTop + listView.getPaddingTop());
    }

    private final void o(PopupWindow popupWindow, int i3, View view) {
        int i16;
        String str;
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        PageInfo nearestPageInfoWithPgId = guildDTReportApiImpl.getNearestPageInfoWithPgId(view);
        HashMap hashMap = new HashMap();
        hashMap.putAll(guildDTReportApiImpl.getPageInfoParams(nearestPageInfoWithPgId));
        HashMap hashMap2 = new HashMap();
        Integer num = this.itemReportMap.get(this.itemKeys[i3]);
        if (num != null) {
            i16 = num.intValue();
        } else {
            i16 = 0;
        }
        hashMap2.put("sgrp_sort_type", Integer.valueOf(i16));
        HashMap hashMap3 = new HashMap();
        if (nearestPageInfoWithPgId != null) {
            str = nearestPageInfoWithPgId.getPageId();
        } else {
            str = null;
        }
        hashMap3.put("dt_pgid", str);
        hashMap3.put("cur_pg", hashMap);
        hashMap3.putAll(hashMap2);
        VideoReport.setElementId(popupWindow.getContentView(), "em_sgrp_sort_panel");
        VideoReport.reportEvent("imp", popupWindow.getContentView(), hashMap3);
    }

    public final void p(@NotNull View anchor, int initialSelected) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow == null) {
            this.popupWindow = k();
        }
        VideoReport.setLogicParent(m(), anchor);
        l().e(initialSelected);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            if (!popupWindow.isShowing()) {
                popupWindow.showAsDropDown(anchor, 0, n());
            } else {
                popupWindow.update(anchor, 0, n(), popupWindow.getWidth(), popupWindow.getHeight());
            }
            o(popupWindow, initialSelected, anchor);
        }
    }
}
