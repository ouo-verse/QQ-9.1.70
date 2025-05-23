package na0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lna0/h;", "Lna0/e;", "", DomainData.DOMAIN_NAME, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "ivNormal", "Landroid/widget/TextView;", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/TextView;", "tvNormal", "", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Landroid/view/View;", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h extends e {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView ivNormal;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextView tvNormal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        ImageView imageView;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        View findViewById = plusEntryLayout.findViewById(R.id.f501824p);
        if (findViewById != null) {
            imageView = (ImageView) findViewById.findViewById(R.id.f502624x);
        } else {
            imageView = null;
        }
        this.ivNormal = imageView;
        View findViewById2 = plusEntryLayout.findViewById(R.id.f501824p);
        this.tvNormal = findViewById2 != null ? (TextView) findViewById2.findViewById(R.id.f502724y) : null;
    }

    @Override // na0.e, na0.d, na0.a, com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-QTabPlusEntryNormalComposerExpE";
    }

    @Override // na0.e, na0.d
    public int n() {
        return R.drawable.qvideo_skin_icon_tab_publish_experiment4_dark;
    }

    @Override // na0.e, na0.d
    @Nullable
    /* renamed from: o, reason: from getter */
    protected ImageView getIvNormal() {
        return this.ivNormal;
    }

    @Override // na0.e, na0.d
    public int q() {
        return r();
    }

    @Override // na0.e, na0.d
    public int r() {
        return R.drawable.qvideo_skin_icon_tab_publish_experiment4_default;
    }

    @Override // na0.e
    @Nullable
    /* renamed from: z, reason: from getter */
    protected TextView getTvNormal() {
        return this.tvNormal;
    }
}
