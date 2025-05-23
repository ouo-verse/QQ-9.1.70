package os;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0015"}, d2 = {"Los/a;", "", "", "key", "", "value", "", "e", "default", "b", h.F, "d", "", "f", "c", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "g", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f423933a = new a();

    a() {
    }

    public final LocalMediaInfo a() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) from.decodeParcelable("selected_local_infos", LocalMediaInfo.class, null);
        from.removeKey("selected_local_infos");
        from.commitAsync();
        return localMediaInfo;
    }

    public final boolean b(String key, boolean r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return from.decodeBool(key, r46);
    }

    public final int c(String key, int r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return from.decodeInt(key, r46);
    }

    public final String d(String key, String r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r46, "default");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        String decodeString = from.decodeString(key, r46);
        Intrinsics.checkNotNullExpressionValue(decodeString, "mmkv.decodeString(key, default)");
        return decodeString;
    }

    public final void e(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeBool(key, value);
    }

    public final void f(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeInt(key, value);
    }

    public final void g(LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeParcelable("selected_local_infos", info).commitAsync();
    }

    public final void h(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeString(key, value);
    }
}
