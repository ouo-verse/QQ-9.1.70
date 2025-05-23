package com.tencent.qqnt.mycomputer.sectionbar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.IWifiPhotoTempApi;
import com.tencent.mobileqq.wifiphoto.api.IExportFileService;
import com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a;
import com.tencent.qqnt.qbasealbum.utils.g;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/mycomputer/sectionbar/adapter/b;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/aio/mycomputer/model/a;", "data", "", "o", "", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "holder", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "f", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void o(View view, com.tencent.qqnt.aio.mycomputer.model.a data) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_pgid", "pg_aio");
        hashMap.put("qq_eid", "em_bas_computer_import_function_entry");
        hashMap.put("function_name", data.a());
        b.a g16 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
        if (g16 != null) {
            hashMap.putAll(g16.e().a());
        }
        VideoReport.reportEvent("qq_clck", hashMap);
        int c16 = data.c();
        if (c16 != 0) {
            if (c16 == 1) {
                if (!g.f361656a.a()) {
                    QQToast.makeText(view.getContext(), "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5", 0).show();
                    return;
                }
                IExportFileService iExportFileService = (IExportFileService) QRoute.api(IExportFileService.class);
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                iExportFileService.enterExportFile(context, new Intent());
                return;
            }
            return;
        }
        if (((IWifiPhotoTempApi) QRoute.api(IWifiPhotoTempApi.class)).isPcLock()) {
            QQToast.makeText(view.getContext(), "QQ\u5728\u7535\u8111\u4e0a\u5df2\u9501\u5b9a\uff0c\u8bf7\u89e3\u9501\u540e\u91cd\u8bd5", 0).show();
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(view.getContext(), "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5", 0).show();
            return;
        }
        IWifiPhotoService iWifiPhotoService = (IWifiPhotoService) QRoute.api(IWifiPhotoService.class);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        iWifiPhotoService.enterWifiPhoto(context2, "/wifi_photo/push_apply", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(b this$0, com.tencent.qqnt.aio.mycomputer.model.a myComputerData, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(myComputerData, "$myComputerData");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.o(it, myComputerData);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 9;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 9;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void f(@NotNull RecyclerView.ViewHolder holder, @NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        final com.tencent.qqnt.aio.mycomputer.model.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(model, "model");
        if (!(holder instanceof com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a)) {
            return;
        }
        Object a16 = model.a();
        if (a16 instanceof com.tencent.qqnt.aio.mycomputer.model.a) {
            aVar = (com.tencent.qqnt.aio.mycomputer.model.a) a16;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a aVar2 = (com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a) holder;
        aVar2.getIcon().setImageResource(aVar.b());
        aVar2.m().setText(aVar.a());
        aVar2.o();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_pgid", "pg_aio");
        linkedHashMap.put("qq_eid", "em_bas_computer_import_function_entry");
        linkedHashMap.put("function_name", aVar.a());
        b.a g16 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
        if (g16 != null) {
            linkedHashMap.putAll(g16.e().a());
        }
        VideoReport.reportEvent("qq_imp", linkedHashMap);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.mycomputer.sectionbar.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.p(b.this, aVar, view);
            }
        });
        if (aVar.c() == 1) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(holder.itemView.getContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(holder.itemView.c\u2026t, QMMKVFile.FILE_COMMON)");
            String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            if (!fromV2.getBoolean(currentUin + "_export_file_aio_bubble", false)) {
                com.tencent.mobileqq.widget.tip.a.r(holder.itemView.getContext()).S(holder.itemView).k0(0).R(0).o0("\u8de8\u7aef\u4f20\u8f93\u529f\u80fd\u5168\u65b0\u5347\u7ea7").p0(holder.itemView.getContext().getColor(R.color.qui_common_text_primary)).W(holder.itemView.getContext().getColor(R.color.qui_common_bg_top_light)).j0(10.0f, 8.0f, 10.0f, 8.0f).e0(true).T(holder.itemView.getContext().getDrawable(R.drawable.m8j)).b0(5000L).s0();
                fromV2.putBoolean(currentUin + "_export_file_aio_bubble", true);
                fromV2.apply();
            }
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    @NotNull
    public RecyclerView.ViewHolder g(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        a.Companion companion = com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a.INSTANCE;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a(companion.b(context));
    }
}
