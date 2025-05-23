package com.tencent.sqshow.zootopia.nativeui.data.repo;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ag;
import uv4.al;
import uv4.bs;
import uv4.bt;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ(\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ(\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\bR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/d;", "", "", "logString", "", "fromPosInList", "Luv4/bs;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bt;", "callback", "", "e", "Lqu4/a;", "avatarCharacter", "c", "Luv4/ag;", "outfitCfg", "d", "Luv4/l;", "a", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "mAvatarOutFitLiveData", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f371092a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<Integer> mAvatarOutFitLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/d$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/l;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<uv4.l> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f371094d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<uv4.l> f371095e;

        a(int i3, com.tencent.mobileqq.zootopia.api.e<uv4.l> eVar) {
            this.f371094d = i3;
            this.f371095e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.l result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("AvatarOutfitRepo", 1, "deleteAvatarTemplate-" + this.f371094d + " onResultSuccess");
            d.f371092a.b().postValue(Integer.valueOf(this.f371094d));
            com.tencent.mobileqq.zootopia.api.e<uv4.l> eVar = this.f371095e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("AvatarOutfitRepo", 1, "deleteAvatarTemplate-" + this.f371094d + " onResultFailure - " + error + " - " + message);
            com.tencent.mobileqq.zootopia.api.e<uv4.l> eVar = this.f371095e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/d$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bt;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<bt> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f371096d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f371097e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bt> f371098f;

        b(String str, int i3, com.tencent.mobileqq.zootopia.api.e<bt> eVar) {
            this.f371096d = str;
            this.f371097e = i3;
            this.f371098f = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bt result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("AvatarOutfitRepo", 1, this.f371096d + " onResultSuccess, code= " + result.f440391a + ", msg= " + result.f440392b);
            d.f371092a.b().postValue(Integer.valueOf(this.f371097e));
            com.tencent.mobileqq.zootopia.api.e<bt> eVar = this.f371098f;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("AvatarOutfitRepo", 1, this.f371096d + " onResultFailure - " + error + " - " + message);
            com.tencent.mobileqq.zootopia.api.e<bt> eVar = this.f371098f;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    d() {
    }

    private final void e(String logString, int fromPosInList, bs req, com.tencent.mobileqq.zootopia.api.e<bt> callback) {
        t94.c.d(t94.c.f435621a, req, new b(logString, fromPosInList, callback), 0, 4, null);
    }

    public final void a(int fromPosInList, ag outfitCfg, com.tencent.mobileqq.zootopia.api.e<uv4.l> callback) {
        Intrinsics.checkNotNullParameter(outfitCfg, "outfitCfg");
        uv4.k kVar = new uv4.k();
        kVar.f440428a = outfitCfg.f440130a;
        kVar.f440429b = outfitCfg.f440131b;
        t94.c.b(t94.c.f435621a, kVar, new a(fromPosInList, callback), 0, 4, null);
    }

    public final MutableLiveData<Integer> b() {
        return mAvatarOutFitLiveData;
    }

    public final void c(int fromPosInList, qu4.a avatarCharacter, com.tencent.mobileqq.zootopia.api.e<bt> callback) {
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        bs bsVar = new bs();
        bsVar.f440390c = avatarCharacter;
        e("saveAvatarTemplate-" + fromPosInList, fromPosInList, bsVar, callback);
    }

    public final void d(int fromPosInList, ag outfitCfg, com.tencent.mobileqq.zootopia.api.e<bt> callback) {
        Intrinsics.checkNotNullParameter(outfitCfg, "outfitCfg");
        bs bsVar = new bs();
        bsVar.f440388a = outfitCfg.f440130a;
        bsVar.f440389b = outfitCfg.f440131b;
        al alVar = outfitCfg.f440133d;
        bsVar.f440390c = alVar != null ? alVar.f440152a : null;
        e("updateAvatarTemplate-" + fromPosInList, fromPosInList, bsVar, callback);
    }
}
