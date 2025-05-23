package com.tencent.mobileqq.sharepanel.report;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.state.report.SquareReportConst;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\b\u0012\u0004\u0012\u00020\u0002`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/report/SelectedContactReportListener;", "Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$b;", "", "elemId", "", "", "params", "", h.F, "c", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "e", "Z", "b", "d", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "hasImpElementSet", "", "hasSelectedListImp", "Lkotlin/Lazy;", "f", "()Ljava/util/Map;", "commonPageParams", "Lcom/tencent/mobileqq/sharepanel/report/b;", "g", "()Lcom/tencent/mobileqq/sharepanel/report/b;", "contactListReportHelper", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SelectedContactReportListener implements SelectedContactFragment.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> hasImpElementSet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasSelectedListImp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy commonPageParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contactListReportHelper;

    public SelectedContactReportListener(@NotNull final SharePanelParam param) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
            return;
        }
        this.hasImpElementSet = new HashSet<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends Object>>() { // from class: com.tencent.mobileqq.sharepanel.report.SelectedContactReportListener$commonPageParams$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelParam.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends Object> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? a.a(SharePanelParam.this) : (Map) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.commonPageParams = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SelectedContactReportListener$contactListReportHelper$2.INSTANCE);
        this.contactListReportHelper = lazy2;
    }

    private final Map<String, Object> f() {
        return (Map) this.commonPageParams.getValue();
    }

    private final b g() {
        return (b) this.contactListReportHelper.getValue();
    }

    private final void h(String elemId, Map<String, ? extends Object> params) {
        String b16 = g().b(elemId, params);
        if (!this.hasImpElementSet.contains(b16)) {
            this.hasImpElementSet.add(b16);
            g().c(elemId, params);
            g().g(elemId, params);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void i(SelectedContactReportListener selectedContactReportListener, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        selectedContactReportListener.h(str, map);
    }

    @Override // com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.b
    public void Z(@NotNull SharePanelContactItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            g().e("em_share_object", a.b(item));
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.b
    public void a(@NotNull SharePanelContactItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_pgid", "pg_share_mini_chat_box");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int f16 = item.f();
        if (f16 != 0) {
            if (f16 == 1) {
                linkedHashMap2.put("aio_type", "2");
                linkedHashMap2.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, item.e());
            }
        } else {
            linkedHashMap2.put("aio_type", "1");
            linkedHashMap2.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, item.e());
        }
        linkedHashMap2.putAll(f());
        linkedHashMap.put("cur_pg", linkedHashMap2);
        VideoReport.reportEvent("ev_share_pgin", linkedHashMap);
    }

    @Override // com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            i(this, "em_share_back", null, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (!this.hasSelectedListImp) {
            g().d("pg_share_to_list", f());
            g().h();
            this.hasSelectedListImp = true;
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            b.f(g(), "em_share_back", null, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.b
    public void e(@NotNull SharePanelContactItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            h("em_share_object", a.b(item));
        }
    }
}
