package com.tencent.mobileqq.nearbypro.aio.helper;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi;
import com.tencent.mobileqq.nearbypro.api.INearbyProAssistantAdapterApi;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.aio.shortcutbar.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/helper/a;", "Lcom/tencent/aio/main/businesshelper/h;", "", "c", "", "panelEntry", "", "b", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "onCreate", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "getMAioContext", "()Lcom/tencent/aio/api/runtime/a;", "setMAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "mAioContext", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "e", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "getPanelClickListener", "()Lcom/tencent/qqnt/aio/shortcutbar/i;", "setPanelClickListener", "(Lcom/tencent/qqnt/aio/shortcutbar/i;)V", "panelClickListener", "<init>", "()V", "f", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements h {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f253105h = "SquareTempAioDisplayHelper";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i panelClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/aio/helper/a$b", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "", "id", "", "isSelected", "b", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements i {
        b() {
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean a(int id5, boolean isSelected) {
            return a.this.b(id5);
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean b(int id5, boolean isSelected) {
            return a.this.b(id5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(int panelEntry) {
        if (panelEntry != 1003) {
            if (panelEntry != 1005) {
                return false;
            }
            QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.getResources().getString(R.string.f170522l_), 0).show();
            return true;
        }
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.getResources().getString(R.string.f170542lb), 0).show();
        return true;
    }

    private final void c() {
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.e() != null) {
                if (this.panelClickListener == null) {
                    this.panelClickListener = new b();
                }
                com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
                Intrinsics.checkNotNull(aVar2);
                aVar2.e().h(new ShortCutBarEvent.SetShortcutPanelClickListener(this.panelClickListener));
                return;
            }
        }
        j.c().d(getTag(), "[initAndAddListener] mAioContext == null || mAioContext.getMessenger() == null");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return ((INearbyProAIOHelperApi) QRoute.api(INearbyProAIOHelperApi.class)).getNearByProDisplayHelperId();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return f253105h;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b helperParam) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        this.mAioContext = helperParam.a();
        c();
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        if (aVar != null) {
            AIOContact c16 = aVar.g().r().c();
            if (((INearbyProAssistantAdapterApi) QRoute.api(INearbyProAssistantAdapterApi.class)).isLittleAssistant(c16.e(), c16.j()) && (e16 = aVar.e()) != null) {
                e16.h(new AIOTitleEvent.UpdateRight1IvEvent(false, false, null, 11, null));
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.mAioContext = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
