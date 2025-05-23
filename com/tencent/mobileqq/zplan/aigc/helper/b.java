package com.tencent.mobileqq.zplan.aigc.helper;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PortalStorePanelAllData;
import com.tencent.sqshow.zootopia.nativeui.data.repo.p;
import com.tencent.sqshow.zootopia.nativeui.data.repo.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ak;
import uv4.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J.\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0006\u0010\u0013\u001a\u00020\u0006R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/m;", "panelAllData", "", "skipUpdateDataCenter", "", "c", "Luv4/ak;", "avatarData", "d", "e", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "userCacheRsp", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "cb", "g", "b", "Landroidx/lifecycle/Observer;", "a", "Landroidx/lifecycle/Observer;", "mPanelDataObserver", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "mPanelGroupDataRepo", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Observer<PortalStorePanelAllData> mPanelDataObserver = new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.helper.a
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            b.f(b.this, (PortalStorePanelAllData) obj);
        }
    };

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final p mPanelGroupDataRepo = new p();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9135b implements com.tencent.mobileqq.zootopia.api.e<w> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Integer> f330294d;

        C9135b(com.tencent.mobileqq.zootopia.api.e<Integer> eVar) {
            this.f330294d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(w result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f330294d.onResultSuccess(0);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f330294d.onResultFailure(error, message);
        }
    }

    private final void c(PortalStorePanelAllData panelAllData, boolean skipUpdateDataCenter) {
        s.f371156a.b(panelAllData.getGender(), panelAllData.getAvatarData());
        d(panelAllData.getAvatarData(), skipUpdateDataCenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b this$0, PortalStorePanelAllData panelAllData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(panelAllData, "panelAllData");
        this$0.c(panelAllData, panelAllData.getFromCache());
    }

    public final void b() {
        this.mPanelGroupDataRepo.e().removeObserver(this.mPanelDataObserver);
    }

    public final void e() {
        this.mPanelGroupDataRepo.e().observeForever(this.mPanelDataObserver);
    }

    private final void d(ak avatarData, boolean skipUpdateDataCenter) {
        if (!skipUpdateDataCenter) {
            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.z(avatarData);
        } else {
            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.C(avatarData);
        }
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        m94.a b16 = cVar.d().b();
        m94.a b17 = cVar.m().b();
        long currentTimeMillis = System.currentTimeMillis();
        boolean c16 = r94.a.c(b17.getAvatarCharacter(), b16.getAvatarCharacter());
        QLog.i("AvatarDressDataManager", 1, "default:" + cVar.p().b());
        QLog.i("AvatarDressDataManager", 1, "init:" + cVar.q().b());
        QLog.i("AvatarDressDataManager", 1, "currentSaved:" + cVar.d().b());
        QLog.i("AvatarDressDataManager", 1, "current:" + cVar.m().b());
        QLog.i("AvatarDressDataManager", 1, "initDressMap end. isSame:" + c16 + ", duration:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void g(UEAvatarGender gender, boolean userCacheRsp, com.tencent.mobileqq.zootopia.api.e<Integer> cb5) {
        b bVar;
        C9135b c9135b;
        if (cb5 == null) {
            c9135b = null;
            bVar = this;
        } else {
            bVar = this;
            c9135b = new C9135b(cb5);
        }
        p.i(bVar.mPanelGroupDataRepo, "", gender, c9135b, false, "", 0, AvatarEngineType.FILAMENT, userCacheRsp, null, false, 768, null);
    }
}
