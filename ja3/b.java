package ja3;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001QB\u0019\u0012\u0006\u0010M\u001a\u00020&\u0012\b\u00106\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\bN\u0010OJ)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0004H\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0015\u00a2\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\u0016\u0010\u0015\u001a\u00020\u0007*\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0004JJ\u0010!\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001eH\u0004J\"\u0010%\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0004Jh\u0010/\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002 \u0010,\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010+0*\u0012\u0004\u0012\u00020\u00070)2\u0019\u0010.\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00070)\u00a2\u0006\u0002\b-H\u0004\u00a2\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u0016H\u0004R\u0019\u00106\u001a\u0004\u0018\u0001028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u00103\u001a\u0004\b4\u00105R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00128\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010=\u001a\u0004\u0018\u00010\u00128\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:R\u001c\u0010C\u001a\u0004\u0018\u00010>8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010F\u001a\u0004\u0018\u00010>8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bD\u0010@\u001a\u0004\bE\u0010BR\u001c\u0010L\u001a\u0004\u0018\u00010G8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\u00a8\u0006R"}, d2 = {"Lja3/b;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "", "position", "spanCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Object;II)V", "t", "(Ljava/lang/Object;)V", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/Object;I)V", "r", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "", "radius", "E", "", "path", "Landroid/widget/ImageView;", "iv", "requestWidth", "requestHeight", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "", BaseProfileQZoneComponent.KEY_IS_VIDEO, NodeProps.CUSTOM_PROP_ISGIF, "o", "imageView", "with", "height", "D", "Landroid/view/View;", "view", "eid", "Lkotlin/Function1;", "", "", "reportBlock", "Lkotlin/ExtensionFunctionType;", "dataBlock", BdhLogUtil.LogTag.Tag_Conn, "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "B", "Lia3/b;", "Lia3/b;", "v", "()Lia3/b;", "clickListener", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "y", "()Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mask", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Landroid/widget/TextView;", "name", "I", "w", "date", "Landroid/widget/Button;", "J", "Landroid/widget/Button;", HippyTKDListViewAdapter.X, "()Landroid/widget/Button;", "debug", "itemView", "<init>", "(Landroid/view/View;Lia3/b;)V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class b<T> extends RecyclerView.ViewHolder {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ColorDrawable L = new ColorDrawable(Color.parseColor("#22000000"));

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final ia3.b clickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final RoundCornerImageView imageView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final RoundCornerImageView mask;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private final TextView name;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final TextView date;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final Button debug;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lja3/b$a;", "", "Landroid/graphics/drawable/ColorDrawable;", "PLACEHOLDER_DRAWABLE", "Landroid/graphics/drawable/ColorDrawable;", "a", "()Landroid/graphics/drawable/ColorDrawable;", "", "COVER_RATIO_BIG", UserInfo.SEX_FEMALE, "COVER_RATIO_SMALL", "IMAGE_RADIO_BIG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ja3.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorDrawable a() {
            return b.L;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView, @Nullable ia3.b bVar) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.clickListener = bVar;
        this.imageView = (RoundCornerImageView) itemView.findViewById(R.id.f123557gz);
        this.mask = (RoundCornerImageView) itemView.findViewById(R.id.xab);
        this.name = (TextView) itemView.findViewById(R.id.f123567h0);
        this.date = (TextView) itemView.findViewById(R.id.f123537gx);
        this.debug = (Button) itemView.findViewById(R.id.f123547gy);
    }

    public static /* synthetic */ void H(b bVar, RoundCornerImageView roundCornerImageView, float f16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                f16 = 8.0f;
            }
            bVar.E(roundCornerImageView, f16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCorner");
    }

    public static /* synthetic */ void p(b bVar, String str, ImageView imageView, int i3, int i16, Drawable drawable, boolean z16, boolean z17, int i17, Object obj) {
        Drawable drawable2;
        boolean z18;
        boolean z19;
        if (obj == null) {
            if ((i17 & 16) != 0) {
                drawable2 = L;
            } else {
                drawable2 = drawable;
            }
            if ((i17 & 32) != 0) {
                z18 = false;
            } else {
                z18 = z16;
            }
            if ((i17 & 64) != 0) {
                z19 = false;
            } else {
                z19 = z17;
            }
            bVar.o(str, imageView, i3, i16, drawable2, z18, z19);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindCover");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: A, reason: from getter */
    public final TextView getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(@Nullable View view, @NotNull String eid) {
        Intrinsics.checkNotNullParameter(eid, "eid");
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, eid);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C(@Nullable View view, @NotNull String eid, @Nullable T data, @NotNull Function1<? super Map<String, Object>, Unit> reportBlock, @NotNull Function1<? super T, Unit> dataBlock) {
        int i3;
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(reportBlock, "reportBlock");
        Intrinsics.checkNotNullParameter(dataBlock, "dataBlock");
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, eid);
        if (data != null) {
            i3 = data.hashCode();
        } else {
            i3 = 0;
        }
        VideoReport.setElementReuseIdentifier(view, String.valueOf(i3));
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportBlock.invoke(reportMap);
        VideoReport.setElementParams(view, reportMap);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        dataBlock.invoke(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D(@Nullable ImageView imageView, int with, int height) {
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        if (imageView != null) {
            layoutParams = imageView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = with;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = height;
            imageView.setLayoutParams(layoutParams2);
            imageView.requestLayout();
        }
    }

    protected final void E(@NotNull RoundCornerImageView roundCornerImageView, float f16) {
        Intrinsics.checkNotNullParameter(roundCornerImageView, "<this>");
        roundCornerImageView.setCorner(x.a(f16));
    }

    public void m(@Nullable T data, int position, int spanCount) {
        if (data != null) {
            t(data);
            u(data);
            q(data);
            s(data, spanCount);
            n(data);
            r(data);
        }
    }

    public abstract void n(T data);

    protected final void o(@Nullable String path, @Nullable ImageView iv5, int requestWidth, int requestHeight, @NotNull Drawable placeholderDrawable, boolean isVideo, boolean isGif) {
        Intrinsics.checkNotNullParameter(placeholderDrawable, "placeholderDrawable");
        if (path == null || iv5 == null) {
            return;
        }
        Option obtain = Option.obtain();
        obtain.setTargetView(iv5);
        obtain.setUrl(path);
        obtain.setRequestWidth(requestWidth);
        obtain.setRequestHeight(requestHeight);
        obtain.setLoadingDrawable(placeholderDrawable);
        obtain.setFailedDrawable(placeholderDrawable);
        if (isVideo) {
            obtain.setPreferDecoder(f11.a.class);
        }
        if (isGif) {
            obtain.setPreferDecoder(h.class);
        }
        QQPicLoader.f201806a.d().loadImage(obtain, null);
    }

    public abstract void q(T data);

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void r(T data) {
        Button button = this.debug;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(T data, int spanCount) {
        RoundCornerImageView roundCornerImageView = this.imageView;
        if (roundCornerImageView != null) {
            H(this, roundCornerImageView, 0.0f, 1, null);
            roundCornerImageView.setFilterPressEffect(true);
            roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    protected void t(T data) {
        RoundCornerImageView roundCornerImageView = this.mask;
        if (roundCornerImageView != null) {
            H(this, roundCornerImageView, 0.0f, 1, null);
        }
    }

    public abstract void u(T data);

    @Nullable
    /* renamed from: v, reason: from getter */
    public final ia3.b getClickListener() {
        return this.clickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: w, reason: from getter */
    public final TextView getDate() {
        return this.date;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: x, reason: from getter */
    public final Button getDebug() {
        return this.debug;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: y, reason: from getter */
    public final RoundCornerImageView getImageView() {
        return this.imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: z, reason: from getter */
    public final RoundCornerImageView getMask() {
        return this.mask;
    }
}
