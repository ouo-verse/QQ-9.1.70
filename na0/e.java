package na0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0017J\b\u0010\u0007\u001a\u00020\u0002H\u0017J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lna0/e;", "Lna0/d;", "", DomainData.DOMAIN_NAME, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", ReportConstant.COSTREPORT_PREFIX, "u", "t", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "ivNormal", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/TextView;", "tvNormal", "", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Landroid/view/View;", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "l", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class e extends d {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView ivNormal;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextView tvNormal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        ImageView imageView;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        View findViewById = plusEntryLayout.findViewById(R.id.f501524m);
        if (findViewById != null) {
            imageView = (ImageView) findViewById.findViewById(R.id.f502624x);
        } else {
            imageView = null;
        }
        this.ivNormal = imageView;
        View findViewById2 = plusEntryLayout.findViewById(R.id.f501524m);
        this.tvNormal = findViewById2 != null ? (TextView) findViewById2.findViewById(R.id.f502724y) : null;
    }

    @ColorRes
    public int A() {
        return R.color.qui_common_text_primary;
    }

    @Override // na0.d, na0.a, com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-QTabPlusEntryNormalComposerExpB";
    }

    @Override // na0.d
    public int n() {
        return R.drawable.qvideo_skin_icon_tab_publish_experiment1_dark;
    }

    @Override // na0.d
    @Nullable
    /* renamed from: o, reason: from getter */
    protected ImageView getIvNormal() {
        return this.ivNormal;
    }

    @Override // na0.d
    public int q() {
        return R.drawable.qvideo_skin_icon_tab_publish_experiment1_qui;
    }

    @Override // na0.d
    public int r() {
        return R.drawable.qvideo_skin_icon_tab_publish_experiment1_default;
    }

    @Override // na0.d
    public void s() {
        super.s();
        TextView tvNormal = getTvNormal();
        if (tvNormal != null) {
            tvNormal.setTextColor(m(y()));
        }
    }

    @Override // na0.d
    public void t() {
        super.t();
        TextView tvNormal = getTvNormal();
        if (tvNormal != null) {
            tvNormal.setTextColor(m(p()));
        }
    }

    @Override // na0.d
    public void u() {
        super.u();
        TextView tvNormal = getTvNormal();
        if (tvNormal != null) {
            tvNormal.setTextColor(m(A()));
        }
    }

    @ColorRes
    public int y() {
        return R.color.qui_common_text_white;
    }

    @Nullable
    /* renamed from: z, reason: from getter */
    protected TextView getTvNormal() {
        return this.tvNormal;
    }
}
