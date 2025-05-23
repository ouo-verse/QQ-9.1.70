package mk4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.l;
import com.tencent.timi.game.utils.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u00013B/\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u00100\u001a\u00020/\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010#\u00a8\u00064"}, d2 = {"Lmk4/b;", "Lcom/tencent/timi/game/ui/widget/l;", "Landroid/view/View$OnClickListener;", "", "initViews", "Landroid/view/View;", "e0", "Y", NodeProps.ON_DETACHED_FROM_WINDOW, "v", NodeProps.ON_CLICK, "", "J", "I", "type", "", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "K", "Ljava/util/List;", "dataList", "L", "Landroid/view/View;", "blurBackgroundView", "Lmk4/b$a;", "M", "Lmk4/b$a;", "getItemClickListener", "()Lmk4/b$a;", "l0", "(Lmk4/b$a;)V", "itemClickListener", "N", "shadowView", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "cancelButton", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "reasonLinear", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/RelativeLayout;", "contentRootView", ExifInterface.LATITUDE_SOUTH, "reasonTitleTv", "Landroid/content/Context;", "context", "<init>", "(ILjava/util/List;Landroid/content/Context;Landroid/view/View;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends l implements View.OnClickListener {

    /* renamed from: J, reason: from kotlin metadata */
    private final int type;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final List<AdminReason> dataList;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private final View blurBackgroundView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private a itemClickListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final View shadowView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final TextView cancelButton;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout reasonLinear;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout contentRootView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final TextView reasonTitleTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lmk4/b$a;", "", "", "type", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "data", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(int type, @Nullable AdminReason data);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(int i3, @NotNull List<? extends AdminReason> dataList, @NotNull Context context, @Nullable View view) {
        super(context);
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = i3;
        this.dataList = dataList;
        this.blurBackgroundView = view;
        setContentView(R.layout.hv8);
        View findViewById = findViewById(R.id.f84014l4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.shadowView)");
        this.shadowView = findViewById;
        View findViewById2 = findViewById(R.id.f70663m2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.reasonLinear)");
        this.reasonLinear = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.tlc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.cancelButton)");
        this.cancelButton = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.u7v);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.contentRootView)");
        this.contentRootView = (RelativeLayout) findViewById4;
        View findViewById5 = findViewById(R.id.f70683m4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.reasonTitleTv)");
        this.reasonTitleTv = (TextView) findViewById5;
        initViews();
    }

    private final void initViews() {
        RelativeLayout relativeLayout = this.contentRootView;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(Color.parseColor("#F3101016"));
        }
        this.reasonLinear.removeAllViews();
        int dimension = (int) this.reasonLinear.getContext().getResources().getDimension(R.dimen.dfk);
        for (final AdminReason adminReason : this.dataList) {
            View inflate = LayoutInflater.from(this.G).inflate(R.layout.hv9, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.xsd);
            if (textView != null) {
                textView.setText(adminReason.desc);
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: mk4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.k0(b.this, adminReason, view);
                }
            });
            this.reasonLinear.addView(inflate, new LinearLayout.LayoutParams(-1, dimension));
        }
        if (this.type == ni4.b.f420212a.a()) {
            this.reasonTitleTv.setVisibility(0);
        }
        this.cancelButton.setOnClickListener(this);
        this.shadowView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(b this$0, AdminReason reason, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        if (!o.a()) {
            a aVar = this$0.itemClickListener;
            if (aVar != null) {
                aVar.a(this$0.type, reason);
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    public View Y() {
        return this.contentRootView;
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    /* renamed from: e0, reason: from getter */
    public View getShadowView() {
        return this.shadowView;
    }

    public final void l0(@Nullable a aVar) {
        this.itemClickListener = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.a()) {
            int id5 = v3.getId();
            boolean z16 = true;
            if (id5 != R.id.f84014l4 && id5 != R.id.tlc) {
                z16 = false;
            }
            if (z16) {
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.timi.game.ui.widget.b, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
