package bp3;

import com.tencent.kuikly.core.views.bg;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R(\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\r\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lbp3/i;", "Lbp3/j;", "Lbp3/d;", "placeholder", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/kuikly/core/views/bg;", "t", "", "other", "", "equals", "", "p", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "placeholderId", "getAlternateText", "alternateText", "<set-?>", "r", "Lcom/tencent/kuikly/core/views/bg;", "()Lcom/tencent/kuikly/core/views/bg;", "placeholderSpan", "Lbp3/d;", "()Lbp3/d;", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class i extends j {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final String placeholderId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final String alternateText;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private bg placeholderSpan;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private d placeholder;

    /* renamed from: p, reason: from getter */
    public final d getPlaceholder() {
        return this.placeholder;
    }

    /* renamed from: q, reason: from getter */
    public final String getPlaceholderId() {
        return this.placeholderId;
    }

    /* renamed from: r, reason: from getter */
    public final bg getPlaceholderSpan() {
        return this.placeholderSpan;
    }

    public final void s(d placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.placeholder = placeholder;
        this.placeholderSpan = t();
    }

    public final bg t() {
        d dVar = this.placeholder;
        if (dVar == null) {
            return null;
        }
        Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.ntcompose.ui.text.InlineTextContent");
        dVar.a();
        new bg();
        throw null;
    }

    @Override // bp3.j, bp3.k
    public boolean equals(Object other) {
        d dVar;
        if (this == other) {
            return true;
        }
        if (!(other instanceof i)) {
            return false;
        }
        i iVar = (i) other;
        if (!Intrinsics.areEqual(this.placeholderId, iVar.placeholderId) || !Intrinsics.areEqual(this.alternateText, iVar.alternateText)) {
            return false;
        }
        d dVar2 = this.placeholder;
        if (dVar2 == null || (dVar = iVar.placeholder) == null || Intrinsics.areEqual(dVar2, dVar)) {
            return super.equals(other);
        }
        return false;
    }
}
