package b94;

import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.zplan.luabridge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s94.FaceControlPointData;
import s94.FaceInfoSyncData;
import tl.h;
import uv4.am;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&JH\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u001c\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00162\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J0\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u001bH&J\u0014\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010&\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010(\u001a\u00020'H\u0016\u00a8\u0006)"}, d2 = {"Lb94/a;", "", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "getType", "", "params", "Lcom/tencent/zplan/luabridge/a$b;", "cb", "", "l", "from", "Lqu4/a;", "avatarCharacter", "Lorg/json/JSONObject;", "clickedItemParam", "tag", "Lcom/tencent/zplan/zplantracing/b;", "zplanSpan", "d", "Ls94/b;", "data", "b", "Ls94/a;", "j", "Luv4/am;", "aiCameraCfg", "currentCameraCfg", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "e", "k", "i", "f", "", "enable", h.F, "c", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface a {
    FilamentUrlTemplate a();

    void b(FaceInfoSyncData data, a.b cb5);

    void c(boolean enable);

    void d(String from, qu4.a avatarCharacter, JSONObject clickedItemParam, String tag, a.b cb5, com.tencent.zplan.zplantracing.b zplanSpan);

    void e(am aiCameraCfg, am currentCameraCfg, a.b cb5, ZootopiaSource source);

    void f();

    void g(qu4.a avatarCharacter);

    AvatarEngineType getType();

    void h(boolean enable);

    void i();

    void j(FaceControlPointData data, a.b cb5);

    void k(a.b cb5);

    void l(String params, a.b cb5);

    void m(qu4.a avatarCharacter, com.tencent.zplan.zplantracing.b zplanSpan);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: b94.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0113a {
        public static FilamentUrlTemplate c(a aVar) {
            return FilamentFeatureUtil.f106409g.F();
        }

        public static void e(a aVar, qu4.a avatarCharacter) {
            Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        }

        public static void k(a aVar, qu4.a avatarCharacter, com.tencent.zplan.zplantracing.b bVar) {
            Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        }

        public static /* synthetic */ void d(a aVar, a.b bVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    bVar = null;
                }
                aVar.k(bVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetRotation");
        }

        public static /* synthetic */ void j(a aVar, FaceInfoSyncData faceInfoSyncData, a.b bVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bVar = null;
                }
                aVar.b(faceInfoSyncData, bVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncFaceInfo");
        }

        public static /* synthetic */ void l(a aVar, qu4.a aVar2, com.tencent.zplan.zplantracing.b bVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bVar = null;
                }
                aVar.m(aVar2, bVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateColorInfo");
        }

        public static /* synthetic */ void b(a aVar, am amVar, am amVar2, a.b bVar, ZootopiaSource zootopiaSource, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bVar = null;
                }
                if ((i3 & 8) != 0) {
                    zootopiaSource = ZootopiaSource.INSTANCE.g();
                }
                aVar.e(amVar, amVar2, bVar, zootopiaSource);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterAiMakeFace");
        }

        public static void h(a aVar) {
        }

        public static void i(a aVar) {
        }

        public static /* synthetic */ void a(a aVar, String str, qu4.a aVar2, JSONObject jSONObject, String str2, a.b bVar, com.tencent.zplan.zplantracing.b bVar2, int i3, Object obj) {
            if (obj == null) {
                aVar.d(str, aVar2, (i3 & 4) != 0 ? null : jSONObject, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : bVar, (i3 & 32) != 0 ? null : bVar2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeAvatarDress");
        }

        public static void f(a aVar, boolean z16) {
        }

        public static void g(a aVar, boolean z16) {
        }
    }
}
