package com.tencent.mobileqq.wink.share;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.IWinkNewSharePanelApi;
import com.tencent.mobileqq.wink.api.IWinkShareAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.share.s;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002JB\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJT\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015JT\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015JT\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015J5\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J5\u0010\"\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\"\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/share/WinkShareManager;", "", "", WadlProxyConsts.SCENE_ID, "", ReportConstant.COSTREPORT_PREFIX, "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/api/c;", "data", "Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "shareModel", "", "shareType", "Lkotlin/Function2;", "", "callback", "l", "Lcom/tencent/mobileqq/wink/share/c;", "oldShareModel", "clickCallback", "Lkotlin/Function0;", "dismissCallback", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/share/a;", "i", "info", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "requestCode", "serviceId", tl.h.F, "(Lcom/tencent/mobileqq/wink/share/c;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "businessId", "g", "(Lcom/tencent/mobileqq/wink/share/a;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkShareManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkShareManager f326323a = new WinkShareManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/share/WinkShareManager$a", "Lcom/tencent/mobileqq/wink/api/d;", "", "getShareType", "", "getShareUrl", "Lkotlin/Function2;", "", "", "a", "Lkotlin/Function0;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.mobileqq.wink.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f326324a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkShareCommonModel f326325b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, Boolean, Unit> f326326c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f326327d;

        /* JADX WARN: Multi-variable type inference failed */
        a(int i3, WinkShareCommonModel winkShareCommonModel, Function2<? super String, ? super Boolean, Unit> function2, Function0<Unit> function0) {
            this.f326324a = i3;
            this.f326325b = winkShareCommonModel;
            this.f326326c = function2;
            this.f326327d = function0;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function2<String, Boolean, Unit> a() {
            return this.f326326c;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function0<Unit> b() {
            return this.f326327d;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        /* renamed from: getShareType, reason: from getter */
        public int getF326335a() {
            return this.f326324a;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @NotNull
        public String getShareUrl() {
            return this.f326325b.getShareUrl();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/share/WinkShareManager$b", "Lcom/tencent/mobileqq/wink/api/d;", "", "getShareType", "", "getShareUrl", "Lkotlin/Function2;", "", "", "a", "Lkotlin/Function0;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.mobileqq.wink.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f326328a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkShareCommonModel f326329b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, Boolean, Unit> f326330c;

        /* JADX WARN: Multi-variable type inference failed */
        b(int i3, WinkShareCommonModel winkShareCommonModel, Function2<? super String, ? super Boolean, Unit> function2) {
            this.f326328a = i3;
            this.f326329b = winkShareCommonModel;
            this.f326330c = function2;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function2<String, Boolean, Unit> a() {
            return this.f326330c;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function0<Unit> b() {
            return null;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        /* renamed from: getShareType, reason: from getter */
        public int getF326335a() {
            return this.f326328a;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @NotNull
        public String getShareUrl() {
            return this.f326329b.getShareUrl();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/share/WinkShareManager$c", "Lcom/tencent/mobileqq/wink/api/d;", "", "getShareType", "", "getShareUrl", "Lkotlin/Function2;", "", "", "a", "Lkotlin/Function0;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f326331a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkShareCommonModel f326332b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, Boolean, Unit> f326333c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f326334d;

        /* JADX WARN: Multi-variable type inference failed */
        c(int i3, WinkShareCommonModel winkShareCommonModel, Function2<? super String, ? super Boolean, Unit> function2, Function0<Unit> function0) {
            this.f326331a = i3;
            this.f326332b = winkShareCommonModel;
            this.f326333c = function2;
            this.f326334d = function0;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function2<String, Boolean, Unit> a() {
            return this.f326333c;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function0<Unit> b() {
            return this.f326334d;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        /* renamed from: getShareType, reason: from getter */
        public int getF326335a() {
            return this.f326331a;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @NotNull
        public String getShareUrl() {
            return this.f326332b.getShareUrl();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/share/WinkShareManager$d", "Lcom/tencent/mobileqq/wink/api/d;", "", "getShareType", "", "getShareUrl", "Lkotlin/Function2;", "", "", "a", "Lkotlin/Function0;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements com.tencent.mobileqq.wink.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f326335a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkShareCommonModel f326336b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, Boolean, Unit> f326337c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f326338d;

        /* JADX WARN: Multi-variable type inference failed */
        d(int i3, WinkShareCommonModel winkShareCommonModel, Function2<? super String, ? super Boolean, Unit> function2, Function0<Unit> function0) {
            this.f326335a = i3;
            this.f326336b = winkShareCommonModel;
            this.f326337c = function2;
            this.f326338d = function0;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function2<String, Boolean, Unit> a() {
            return this.f326337c;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @Nullable
        public Function0<Unit> b() {
            return this.f326338d;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        /* renamed from: getShareType, reason: from getter */
        public int getF326335a() {
            return this.f326335a;
        }

        @Override // com.tencent.mobileqq.wink.api.d
        @NotNull
        public String getShareUrl() {
            return this.f326336b.getShareUrl();
        }
    }

    WinkShareManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    @NotNull
    public final WinkShareCommonModel g(@NotNull com.tencent.mobileqq.wink.share.a info, @NotNull String businessId, @Nullable Integer requestCode, @Nullable String serviceId) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        WinkShareCommonModel winkShareCommonModel = new WinkShareCommonModel(info.getTitle(), info.getPreview(), info.getDesc(), info.getShareUrl());
        winkShareCommonModel.setRequestArkBusId(businessId);
        winkShareCommonModel.setShareExternalUrl(info.getShareExternalUrl());
        winkShareCommonModel.setShareQZoneUrl(info.getShareQZoneUrl());
        winkShareCommonModel.setNewArkRequest(true);
        if (requestCode != null) {
            requestCode.intValue();
            winkShareCommonModel.setRequestQQId(requestCode.intValue());
            winkShareCommonModel.setRequestQZoneId(requestCode.intValue());
            winkShareCommonModel.setRequestGuildId(requestCode.intValue());
        }
        if (serviceId != null) {
            winkShareCommonModel.setServiceId(WinkShareUtils.INSTANCE.h(serviceId));
        }
        Bundle bundle = new Bundle();
        bundle.putString("material_id", serviceId);
        winkShareCommonModel.setExtraParams(bundle);
        return winkShareCommonModel;
    }

    @NotNull
    public final WinkShareCommonModel h(@NotNull com.tencent.mobileqq.wink.share.c info, @NotNull String materialId, @Nullable Integer requestCode, @Nullable String serviceId) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        WinkShareCommonModel winkShareCommonModel = new WinkShareCommonModel(info.getTitle(), info.getPreview(), info.getDesc(), info.getShareUrl());
        winkShareCommonModel.setShareExternalUrl(info.getShareExternalUrl());
        winkShareCommonModel.setNewArkRequest(false);
        if (requestCode != null) {
            requestCode.intValue();
            winkShareCommonModel.setRequestQQId(requestCode.intValue());
            winkShareCommonModel.setRequestQZoneId(requestCode.intValue());
            winkShareCommonModel.setRequestGuildId(requestCode.intValue());
        }
        if (serviceId != null) {
            winkShareCommonModel.setServiceId(WinkShareUtils.INSTANCE.h(serviceId));
        }
        Bundle bundle = new Bundle();
        bundle.putString("material_id", materialId);
        winkShareCommonModel.setExtraParams(bundle);
        return winkShareCommonModel;
    }

    public final void i(@NotNull FragmentActivity activity, @NotNull com.tencent.mobileqq.wink.share.a oldShareModel, @NotNull WinkShareCommonModel shareModel, int shareType, @Nullable final Function2<? super String, ? super Boolean, Unit> clickCallback, @Nullable final Function0<Unit> dismissCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(oldShareModel, "oldShareModel");
        Intrinsics.checkNotNullParameter(shareModel, "shareModel");
        if (s("ai_touxiang")) {
            QRouteApi api = QRoute.api(IWinkNewSharePanelApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IWinkNewSharePanelApi::class.java)");
            IWinkNewSharePanelApi.a.a((IWinkNewSharePanelApi) api, "ai_touxiang", activity, new a(shareType, shareModel, clickCallback, dismissCallback), shareModel, null, false, 48, null);
        } else {
            h hVar = null;
            s.a i3 = new s.a().c(s.a.INSTANCE.a(), null).h(0, 0, 8).i("biz_src_jc_qzone");
            String requestArkBusId = shareModel.getRequestArkBusId();
            if (requestArkBusId != null) {
                hVar = new h(activity, oldShareModel, requestArkBusId, 52136, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareManager$shareAIAvatar$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0<Unit> function0 = dismissCallback;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }
                }, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareManager$shareAIAvatar$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        Function2<String, Boolean, Unit> function2;
                        if (!z16 || (function2 = clickCallback) == null) {
                            return;
                        }
                        function2.invoke("weixin", Boolean.TRUE);
                    }
                }, requestArkBusId);
            }
            i3.e(hVar).d(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.wink.share.n
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    WinkShareManager.j(Function0.this, dialogInterface);
                }
            }).f(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.share.o
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WinkShareManager.k(Function0.this, dialogInterface);
                }
            }).a(activity).show();
        }
    }

    public final void l(@NotNull FragmentActivity activity, @NotNull com.tencent.mobileqq.wink.api.c data, @NotNull WinkShareCommonModel shareModel, int shareType, @Nullable Function2<? super String, ? super Boolean, Unit> callback) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(shareModel, "shareModel");
        if (2 == shareType) {
            str = "qzone_aixiaochu";
        } else {
            str = "qzone_aixiaochuresult";
        }
        String str3 = str;
        if (s(str3)) {
            QRouteApi api = QRoute.api(IWinkNewSharePanelApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IWinkNewSharePanelApi::class.java)");
            IWinkNewSharePanelApi.a.a((IWinkNewSharePanelApi) api, str3, activity, new b(shareType, shareModel, callback), shareModel, null, false, 48, null);
        } else {
            if (1 == shareType) {
                str2 = shareModel.getShareUrl();
            } else {
                str2 = "";
            }
            ((IWinkShareAPI) QRoute.api(IWinkShareAPI.class)).showAIEliminationSharePanel(activity, str2, data);
        }
    }

    public final void m(@NotNull FragmentActivity activity, @NotNull com.tencent.mobileqq.wink.share.c oldShareModel, @NotNull WinkShareCommonModel shareModel, int shareType, @Nullable final Function2<? super String, ? super Boolean, Unit> clickCallback, @Nullable final Function0<Unit> dismissCallback) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(oldShareModel, "oldShareModel");
        Intrinsics.checkNotNullParameter(shareModel, "shareModel");
        if (s("qzone_aimiaohui")) {
            QRouteApi api = QRoute.api(IWinkNewSharePanelApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IWinkNewSharePanelApi::class.java)");
            IWinkNewSharePanelApi.a.a((IWinkNewSharePanelApi) api, "qzone_aimiaohui", activity, new c(shareType, shareModel, clickCallback, dismissCallback), shareModel, null, false, 48, null);
            return;
        }
        s.a i3 = new s.a().c(s.a.INSTANCE.a(), null).h(0, 0, 8).i("biz_src_jc_qzone");
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareManager$shareMagicStudioAITemplate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0<Unit> function02 = dismissCallback;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        };
        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareManager$shareMagicStudioAITemplate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Function2<String, Boolean, Unit> function2;
                if (!z16 || (function2 = clickCallback) == null) {
                    return;
                }
                function2.invoke("weixin", Boolean.TRUE);
            }
        };
        Bundle extraParams = shareModel.getExtraParams();
        if (extraParams == null || (str = extraParams.getString("material_id")) == null) {
            str = "";
        }
        i3.e(new i(activity, oldShareModel, "qzoneTemplateLibrary", 52130, function0, function1, str)).d(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.wink.share.j
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                WinkShareManager.n(Function0.this, dialogInterface);
            }
        }).f(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.share.k
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                WinkShareManager.o(Function0.this, dialogInterface);
            }
        }).a(activity).show();
    }

    public final void p(@NotNull FragmentActivity activity, @NotNull com.tencent.mobileqq.wink.share.c oldShareModel, @NotNull WinkShareCommonModel shareModel, int shareType, @Nullable final Function2<? super String, ? super Boolean, Unit> clickCallback, @Nullable final Function0<Unit> dismissCallback) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(oldShareModel, "oldShareModel");
        Intrinsics.checkNotNullParameter(shareModel, "shareModel");
        if (s("qzone_aimiaohui")) {
            QRouteApi api = QRoute.api(IWinkNewSharePanelApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IWinkNewSharePanelApi::class.java)");
            IWinkNewSharePanelApi.a.a((IWinkNewSharePanelApi) api, "qzone_aimiaohui", activity, new d(shareType, shareModel, clickCallback, dismissCallback), shareModel, null, false, 48, null);
        } else {
            s.a h16 = new s.a().c(s.a.INSTANCE.a(), null).h(0, 0, 8);
            if (r93.h.f430993a.g()) {
                str = "qzoneMagicStudio";
            } else {
                str = QQWinkConstants.BUSINESS_MAIGC_STUDIO;
            }
            h16.e(new i(activity, oldShareModel, str, 52129, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareManager$shareMagicStudioCreationTemplate$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0<Unit> function0 = dismissCallback;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            }, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareManager$shareMagicStudioCreationTemplate$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    Function2<String, Boolean, Unit> function2;
                    if (!z16 || (function2 = clickCallback) == null) {
                        return;
                    }
                    function2.invoke("weixin", Boolean.TRUE);
                }
            }, null, 64, null)).d(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.wink.share.l
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    WinkShareManager.q(Function0.this, dialogInterface);
                }
            }).f(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.share.m
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WinkShareManager.r(Function0.this, dialogInterface);
                }
            }).a(activity).show();
        }
    }

    public final boolean s(@NotNull String sceneId) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        return ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel(sceneId);
    }
}
