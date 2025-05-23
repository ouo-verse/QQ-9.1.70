package com.tencent.mobileqq.search.searchdetail.function;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.multimedia.o;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import hp2.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\rB#\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/function/b;", "", "Lcom/tencent/mobileqq/search/searchdetail/function/d;", "data", "", "c", "Landroid/widget/ImageView;", "imageView", "", "url", "b", "d", "Lhp2/n;", "a", "Lhp2/n;", "getBinding", "()Lhp2/n;", "binding", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "Lkotlin/jvm/functions/Function1;", "jumpCallback", "Lcom/tencent/mobileqq/search/searchdetail/function/d;", "currentData", "<init>", "(Lhp2/n;Lkotlin/jvm/functions/Function1;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<SearchJump, Unit> jumpCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NetSearchFunctionItem currentData;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull n binding, @NotNull Function1<? super SearchJump, Unit> jumpCallback) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(jumpCallback, "jumpCallback");
        this.binding = binding;
        this.jumpCallback = jumpCallback;
    }

    private final void b(ImageView imageView, String url) {
        o.g(o.f284545a, "QQSearch.NetDetail.NetSearchFunctionCard", imageView, url, null, 8, null);
    }

    private final void c(NetSearchFunctionItem data) {
        AppInterface appInterface;
        AppInterface appInterface2;
        boolean z16;
        QLog.d("QQSearch.NetDetail.NetSearchFunctionCard", 4, "openLastFunction");
        Context context = this.binding.getRoot().getContext();
        if (context == null) {
            return;
        }
        String jumpUrl = data.getJumpUrl();
        IQQHealthService iQQHealthService = null;
        if (!TextUtils.isEmpty(jumpUrl)) {
            SearchUtils.Q0(null, context, jumpUrl);
            return;
        }
        String fid = data.getFid();
        boolean z17 = false;
        if (Intrinsics.areEqual("63", fid)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface2 = (AppInterface) peekAppRuntime;
            } else {
                appInterface2 = null;
            }
            if (appInterface2 != null && ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivityBySearch(context, appInterface2)) {
                return;
            }
            if (appInterface2 == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.w("QQSearch.NetDetail.NetSearchFunctionCard", 1, "is ID_WEATHER, but jump failed, app is null:" + z16);
        }
        if (Intrinsics.areEqual("24", fid)) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime2;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iQQHealthService = (IQQHealthService) appInterface.getRuntimeService(IQQHealthService.class, ProcessConstant.MULTI);
            }
            if (iQQHealthService != null && iQQHealthService.redirectAIOToMainPage(appInterface.getApplicationContext(), 166)) {
                return;
            }
            if (iQQHealthService == null) {
                z17 = true;
            }
            QLog.w("QQSearch.NetDetail.NetSearchFunctionCard", 1, "is ID_HEALTH, but jump failed, service is null:" + z17);
        }
        if (!TextUtils.isEmpty(fid)) {
            Integer valueOf = Integer.valueOf(fid);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(id)");
            SearchUtils.A0(context, valueOf.intValue(), 21012);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NetSearchFunctionItem netSearchFunctionItem = this$0.currentData;
        if (netSearchFunctionItem != null) {
            this$0.c(netSearchFunctionItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d(@NotNull NetSearchFunctionItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentData = data;
        this.binding.f405701d.setText(data.getText());
        ImageFilterView imageFilterView = this.binding.f405700c;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.netSearchFunctionIcon");
        b(imageFilterView, data.getImageUrl());
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.function.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.e(b.this, view);
            }
        });
    }
}
