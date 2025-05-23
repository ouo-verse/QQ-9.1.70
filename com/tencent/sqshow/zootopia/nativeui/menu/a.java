package com.tencent.sqshow.zootopia.nativeui.menu;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaPortalGiftData;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarPanelAllData;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PortalStorePanelAllData;
import com.tencent.sqshow.zootopia.nativeui.data.repo.i;
import com.tencent.sqshow.zootopia.nativeui.data.repo.p;
import com.tencent.sqshow.zootopia.widget.menu.ZplanMenuDataItem;
import com.tencent.sqshow.zootopia.widget.menu.ZplanMenuPopupView;
import g94.b;
import g94.c;
import java.util.HashMap;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.at;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0002\u001e\"B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J,\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0001`\u001a2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J*\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u001d\u001a\u00020\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/menu/a;", "", "Luv4/az;", "itemData", "Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView;", "menu", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Landroid/view/View;", "archView", "", "i", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "viewHolder", "g", "f", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/menu/MenuDefine;", "define", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "itemActionHandler", "Lcom/tencent/sqshow/zootopia/widget/menu/b;", "c", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "e", "j", "d", "a", "Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView;", "<init>", "()V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final a f371288c = C9816a.f371290a.a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZplanMenuPopupView menu;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/menu/a$a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/menu/a;", "b", "Lcom/tencent/sqshow/zootopia/nativeui/menu/a;", "a", "()Lcom/tencent/sqshow/zootopia/nativeui/menu/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.menu.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    private static final class C9816a {

        /* renamed from: a, reason: collision with root package name */
        public static final C9816a f371290a = new C9816a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final a instance = new a(null);

        C9816a() {
        }

        public final a a() {
            return instance;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/menu/a$b;", "", "Lcom/tencent/sqshow/zootopia/nativeui/menu/a;", "getInstance", "Lcom/tencent/sqshow/zootopia/nativeui/menu/a;", "a", "()Lcom/tencent/sqshow/zootopia/nativeui/menu/a;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.menu.a$b, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return a.f371288c;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/menu/a$c", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "", "id", "Landroid/view/View;", "view", "", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.sqshow.zootopia.widget.menu.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ az f371293b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f371294c;

        c(az azVar, j jVar) {
            this.f371293b = azVar;
            this.f371294c = jVar;
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void a(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            b.f401562a.b(this.f371293b);
            a.this.e(this.f371293b).put("zplan_keep_status", 1);
            ZplanViewReportHelper.f(this.f371294c.getReporter().getMReporter(), view, "em_zplan_item_float_keep", null, 4, null);
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void b(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HashMap e16 = a.this.e(this.f371293b);
            e16.put("zplan_keep_status", 1);
            this.f371294c.getReporter().getMReporter().g(view, "em_zplan_item_float_keep", (r16 & 4) != 0 ? null : e16, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/menu/a$d", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "", "id", "Landroid/view/View;", "view", "", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.sqshow.zootopia.widget.menu.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ az f371296b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f371297c;

        d(az azVar, j jVar) {
            this.f371296b = azVar;
            this.f371297c = jVar;
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void a(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            b.f401562a.d(this.f371296b);
            b94.e O = this.f371297c.O();
            if (O != null) {
                O.A2();
            }
            ZplanViewReportHelper.f(this.f371297c.getReporter().getMReporter(), view, "em_zplan_item_float_keep", null, 4, null);
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void b(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HashMap e16 = a.this.e(this.f371296b);
            e16.put("zplan_keep_status", 0);
            this.f371297c.getReporter().getMReporter().g(view, "em_zplan_item_float_keep", (r16 & 4) != 0 ? null : e16, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/menu/a$e", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "", "id", "Landroid/view/View;", "view", "", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.sqshow.zootopia.widget.menu.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f371298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f371299b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ az f371300c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseAvatarPanelItemViewHolder f371301d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/menu/a$e$a", "Lg94/c$a;", "", "errCode", "", "errMsg", "", "onFail", "Lu45/d;", "rsp", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.menu.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9817a implements c.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaseAvatarPanelItemViewHolder f371302a;

            C9817a(BaseAvatarPanelItemViewHolder baseAvatarPanelItemViewHolder) {
                this.f371302a = baseAvatarPanelItemViewHolder;
            }

            @Override // g94.c.a
            public void a(u45.d rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QLog.i("MenuHelper", 1, "deleteUgc success.");
                BaseAvatarPanelItemViewHolder baseAvatarPanelItemViewHolder = this.f371302a;
                if (baseAvatarPanelItemViewHolder != null) {
                    baseAvatarPanelItemViewHolder.m0();
                }
            }

            @Override // g94.c.a
            public void onFail(int errCode, String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.e("MenuHelper", 1, "deleteUgc fail. errCode: " + errCode + ", errMsg: " + errMsg);
                QQToast.makeText(BaseApplication.context, 1, "\u5220\u9664\u5931\u8d25", 0).show();
            }
        }

        e(j jVar, a aVar, az azVar, BaseAvatarPanelItemViewHolder baseAvatarPanelItemViewHolder) {
            this.f371298a = jVar;
            this.f371299b = aVar;
            this.f371300c = azVar;
            this.f371301d = baseAvatarPanelItemViewHolder;
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void a(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371298a.getReporter().getMReporter().e(view, "em_zplan_item_float_delete", this.f371299b.e(this.f371300c));
            QLog.i("MenuHelper", 1, "sendDeleteUgcRequest");
            g94.c.f401569a.a(this.f371300c.f440276c, new C9817a(this.f371301d));
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void b(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/menu/a$g", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "", "id", "Landroid/view/View;", "view", "", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements com.tencent.sqshow.zootopia.widget.menu.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f371307a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f371308b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ az f371309c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f371310d;

        g(j jVar, a aVar, az azVar, View view) {
            this.f371307a = jVar;
            this.f371308b = aVar;
            this.f371309c = azVar;
            this.f371310d = view;
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void a(int id5, View view) {
            String str;
            MutableLiveData<PortalStorePanelAllData> e16;
            PortalStorePanelAllData value;
            at commonCfg;
            MutableLiveData<AvatarPanelAllData> b16;
            AvatarPanelAllData value2;
            at commonCfg2;
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371307a.getReporter().getMReporter().e(view, "em_zplan_item_float_give", this.f371308b.e(this.f371309c));
            i dataController = this.f371307a.getDataController();
            if (dataController == null || (b16 = dataController.b()) == null || (value2 = b16.getValue()) == null || (commonCfg2 = value2.getCommonCfg()) == null || (str = commonCfg2.f440223a) == null) {
                p dataControllerV1 = this.f371307a.getDataControllerV1();
                str = (dataControllerV1 == null || (e16 = dataControllerV1.e()) == null || (value = e16.getValue()) == null || (commonCfg = value.getCommonCfg()) == null) ? null : commonCfg.f440223a;
                if (str == null) {
                    str = "";
                }
            }
            ZootopiaPortalGiftData a16 = ZootopiaPortalGiftData.INSTANCE.a(this.f371309c, str);
            ta4.b bVar = ta4.b.f435764a;
            Context context = this.f371310d.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "archView.context");
            bVar.c(context, a16);
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void b(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371307a.getReporter().getMReporter().g(view, "em_zplan_item_float_give", (r16 & 4) != 0 ? null : this.f371308b.e(this.f371309c), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/menu/a$h", "Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView$a;", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements ZplanMenuPopupView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f371311a;

        h(j jVar) {
            this.f371311a = jVar;
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.ZplanMenuPopupView.a
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371311a.getReporter().a(view, "pg_zplan_avatar_mall");
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final ZplanMenuDataItem c(MenuDefine define, com.tencent.sqshow.zootopia.widget.menu.a itemActionHandler) {
        return new ZplanMenuDataItem(define.ordinal(), define.getIconResId(), -1, define.getStr(), itemActionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Object> e(az item) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_item_id", r94.b.K(item));
        hashMap.put("zplan_item_status_type", Integer.valueOf(item.I));
        return hashMap;
    }

    private final void f(j channel, az itemData, ZplanMenuPopupView menu) {
        if (b.f401562a.i(itemData)) {
            menu.b(c(MenuDefine.MENU_UNLIKE, new c(itemData, channel)));
        } else {
            menu.b(c(MenuDefine.MENU_LIKE, new d(itemData, channel)));
        }
    }

    private final void g(az itemData, ZplanMenuPopupView menu, j channel, BaseAvatarPanelItemViewHolder viewHolder) {
        menu.b(c(MenuDefine.MENU_DELETE, new e(channel, this, itemData, viewHolder)));
    }

    private final void h(ZplanMenuPopupView menu, j channel, View archView, az itemData) {
        menu.b(c(MenuDefine.MENU_DETAIL, new f(channel, this, itemData, archView)));
    }

    private final void i(az itemData, ZplanMenuPopupView menu, j channel, View archView) {
        if (itemData.f440285l) {
            menu.b(c(MenuDefine.MENU_GIFT, new g(channel, this, itemData, archView)));
        }
    }

    public final void d() {
        this.menu.e();
    }

    public final void j(View archView, j channel, az itemData, BaseAvatarPanelItemViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(archView, "archView");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (this.menu.g()) {
            this.menu.f();
        }
        this.menu.c();
        h(this.menu, channel, archView, itemData);
        if (!itemData.L) {
            f(channel, itemData, this.menu);
        }
        i(itemData, this.menu, channel, archView);
        if (itemData.J) {
            g(itemData, this.menu, channel, viewHolder);
        }
        int[] iArr = new int[2];
        archView.getLocationOnScreen(iArr);
        this.menu.i(archView, iArr[0] + (archView.getWidth() / 2), iArr[1], new h(channel));
    }

    a() {
        this.menu = new ZplanMenuPopupView();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/menu/a$f", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "", "id", "Landroid/view/View;", "view", "", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements com.tencent.sqshow.zootopia.widget.menu.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f371303a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f371304b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ az f371305c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f371306d;

        f(j jVar, a aVar, az azVar, View view) {
            this.f371303a = jVar;
            this.f371304b = aVar;
            this.f371305c = azVar;
            this.f371306d = view;
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void b(int id5, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371303a.getReporter().getMReporter().g(view, "em_zplan_item_float_detail", (r16 & 4) != 0 ? null : this.f371304b.e(this.f371305c), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }

        @Override // com.tencent.sqshow.zootopia.widget.menu.a
        public void a(int id5, View view) {
            ga4.g a16;
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371303a.getReporter().getMReporter().e(view, "em_zplan_item_float_detail", this.f371304b.e(this.f371305c));
            ga4.j jVar = ga4.j.f401682a;
            j jVar2 = this.f371303a;
            Context context = this.f371306d.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "archView.context");
            a16 = jVar.a(3, jVar2, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(this.f371305c, null, null, null, null, 0, 62, null), (r22 & 16) != 0 ? false : false);
            a16.show();
        }
    }

    public static /* synthetic */ void k(a aVar, View view, j jVar, az azVar, BaseAvatarPanelItemViewHolder baseAvatarPanelItemViewHolder, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            baseAvatarPanelItemViewHolder = null;
        }
        aVar.j(view, jVar, azVar, baseAvatarPanelItemViewHolder);
    }
}
