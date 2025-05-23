package db;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.configx.g;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import qc.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ldb/c;", "Lcom/qzone/reborn/part/publish/common/inputarea/a;", "", "b", "maxLength", "", "c", "", "a", "Lqc/e;", "Lqc/e;", "getSelectAlbumVm", "()Lqc/e;", "selectAlbumVm", "<init>", "(Lqc/e;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends com.qzone.reborn.part.publish.common.inputarea.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final e selectAlbumVm;

    public c(e selectAlbumVm) {
        Intrinsics.checkNotNullParameter(selectAlbumVm, "selectAlbumVm");
        this.selectAlbumVm = selectAlbumVm;
    }

    @Override // com.qzone.reborn.part.publish.common.inputarea.a
    public int b() {
        return g.f53821a.b().T0();
    }

    @Override // com.qzone.reborn.part.publish.common.inputarea.a
    public void c(int maxLength) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String a16 = l.a(R.string.f2195066l);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026it_text_over_limit_toast)");
        String format = String.format(a16, Arrays.copyOf(new Object[]{Integer.valueOf(maxLength)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        d(format);
    }

    @Override // com.qzone.reborn.part.publish.common.inputarea.a
    public String a() {
        String a16 = l.a(R.string.jjg);
        CommonAlbumInfo value = this.selectAlbumVm.Q1().getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.getQzAlbumType()) : null;
        if (valueOf != null && valueOf.intValue() == 11) {
            return l.a(R.string.jjh);
        }
        if (valueOf != null && valueOf.intValue() == 8) {
            return l.a(R.string.jji);
        }
        return (valueOf != null && valueOf.intValue() == 9) ? l.a(R.string.jjt) : a16;
    }
}
