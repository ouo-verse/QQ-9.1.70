package om;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$Botton;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellAction;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellHeader;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$PicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020#\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lom/d;", "Lom/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "e", "Lnm/b;", "itemData", "", com.tencent.luggage.wxa.c8.c.G, "f", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBgImageView", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "mHeaderTextView", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "mTitleContainer", "i", "mContentContainer", "j", "mBottomContainer", "k", "mVisitorContainer", "Landroid/widget/Button;", "l", "Landroid/widget/Button;", "mOperateBtn", "b", "()I", "layoutId", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mBgImageView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mHeaderTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mTitleContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mContentContainer;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mBottomContainer;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mVisitorContainer;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Button mOperateBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ViewGroup rootView) {
        super(rootView);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0, nm.b itemData, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(v3, "v");
        QZoneOfficialAccountBase$CellAction cellAction = itemData.getCellAction();
        Intrinsics.checkNotNull(cellAction);
        this$0.d(cellAction.jump_url.get(), v3.getContext());
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d this$0, nm.b itemData, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(v3, "v");
        QZoneOfficialAccountBase$Botton a16 = itemData.a();
        Intrinsics.checkNotNull(a16);
        this$0.d(a16.jump_url.get(), v3.getContext());
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // om.a
    public int b() {
        return R.layout.cni;
    }

    @Override // om.a
    public void e(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.kuc);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.mBgImageView = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.niy);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mHeaderTextView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.jpl);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mVisitorContainer = (FrameLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.jot);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mTitleContainer = (FrameLayout) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.jpl);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mVisitorContainer = (FrameLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.fyp);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mBottomContainer = (FrameLayout) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.joj);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mContentContainer = (FrameLayout) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f19375i);
        Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type android.widget.Button");
        this.mOperateBtn = (Button) findViewById8;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0148  */
    @Override // om.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(final nm.b itemData, int pos) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData.l() != 1) {
            QLog.e("QZonePublicAccountItemBigCardBuilder", 1, "bindData error\uff0cinvalid data");
            return;
        }
        Button button = null;
        if (!itemData.m() && itemData.k() != null) {
            QZoneOfficialAccountBase$PicInfo k3 = itemData.k();
            Intrinsics.checkNotNull(k3);
            String str = k3.pic_url.get();
            com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
            ImageView imageView = this.mBgImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                imageView = null;
            }
            Option defaultOptions = Option.getDefaultOptions(imageView);
            ImageView imageView2 = this.mBgImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                imageView2 = null;
            }
            a16.h(defaultOptions.setTargetView(imageView2).setUrl(str));
        } else {
            ImageView imageView3 = this.mBgImageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                imageView3 = null;
            }
            imageView3.setImageDrawable(null);
        }
        if (itemData.getCellHeader() != null) {
            TextView textView = this.mHeaderTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderTextView");
                textView = null;
            }
            QZoneOfficialAccountBase$CellHeader cellHeader = itemData.getCellHeader();
            Intrinsics.checkNotNull(cellHeader);
            textView.setText(cellHeader.header_title.get());
            TextView textView2 = this.mHeaderTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderTextView");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            TextView textView3 = this.mHeaderTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderTextView");
                textView3 = null;
            }
            textView3.setVisibility(4);
        }
        pm.d dVar = pm.d.f426464a;
        FrameLayout frameLayout = this.mVisitorContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorContainer");
            frameLayout = null;
        }
        dVar.a(itemData, frameLayout);
        pm.c cVar = pm.c.f426463a;
        FrameLayout frameLayout2 = this.mTitleContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            frameLayout2 = null;
        }
        cVar.a(itemData, frameLayout2);
        pm.b bVar = pm.b.f426462a;
        FrameLayout frameLayout3 = this.mContentContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentContainer");
            frameLayout3 = null;
        }
        bVar.a(itemData, frameLayout3);
        pm.a aVar = pm.a.f426461a;
        FrameLayout frameLayout4 = this.mBottomContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            frameLayout4 = null;
        }
        aVar.a(itemData, frameLayout4);
        if (itemData.getCellAction() != null) {
            QZoneOfficialAccountBase$CellAction cellAction = itemData.getCellAction();
            Intrinsics.checkNotNull(cellAction);
            if (!TextUtils.isEmpty(cellAction.jump_url.get())) {
                getMCardContent().setOnClickListener(new View.OnClickListener() { // from class: om.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.l(d.this, itemData, view);
                    }
                });
                if (itemData.a() == null) {
                    Button button2 = this.mOperateBtn;
                    if (button2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOperateBtn");
                        button2 = null;
                    }
                    button2.setVisibility(0);
                    Button button3 = this.mOperateBtn;
                    if (button3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOperateBtn");
                        button3 = null;
                    }
                    QZoneOfficialAccountBase$Botton a17 = itemData.a();
                    Intrinsics.checkNotNull(a17);
                    button3.setText(a17.caption.get());
                    Button button4 = this.mOperateBtn;
                    if (button4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOperateBtn");
                    } else {
                        button = button4;
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: om.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            d.m(d.this, itemData, view);
                        }
                    });
                    return;
                }
                Button button5 = this.mOperateBtn;
                if (button5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOperateBtn");
                } else {
                    button = button5;
                }
                button.setVisibility(8);
                return;
            }
        }
        getMCardContent().setOnClickListener(null);
        if (itemData.a() == null) {
        }
    }
}
