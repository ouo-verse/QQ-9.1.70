package com.tencent.luggage.opensdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u0002\r\u000fB\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+B\u001b\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b*\u0010.B#\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010/\u001a\u00020\u0003\u00a2\u0006\u0004\b*\u00100B+\b\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u00a2\u0006\u0004\b*\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0017J\b\u0010\u000e\u001a\u00020\u0006H\u0017J\b\u0010\u000f\u001a\u00020\u0006H\u0017J\b\u0010\r\u001a\u00020\u0006H\u0017J\u0012\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0003H\u0002R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R#\u0010\u001b\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001e\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR#\u0010#\u001a\n \u0017*\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u00060$R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00064"}, d2 = {"Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget;", "Landroid/widget/FrameLayout;", "", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/view/View$OnClickListener;", "l", "setOnRefreshButtonClickListener", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "a", "c", "b", "layerId", "I", "DP_142", "", "[Ljava/lang/Integer;", "mLayerIds", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getMQRImage", "()Landroid/widget/ImageView;", "mQRImage", "d", "getMAlertIcon", "mAlertIcon", "Landroid/widget/TextView;", "e", "getMAlertMessage", "()Landroid/widget/TextView;", "mAlertMessage", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$a;", "f", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$a;", "mStateMachine", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "g", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class QRCodeTransferQRDisplayWidget extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int DP_142;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Integer[] mLayerIds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy mQRImage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Lazy mAlertIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Lazy mAlertMessage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final a mStateMachine;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class a extends com.tencent.luggage.wxa.wn.c {

        /* renamed from: d, reason: collision with root package name */
        public final d f120015d;

        /* renamed from: e, reason: collision with root package name */
        public final c f120016e;

        /* renamed from: f, reason: collision with root package name */
        public final e f120017f;

        /* renamed from: g, reason: collision with root package name */
        public final b f120018g;

        /* renamed from: h, reason: collision with root package name */
        public final C5962a f120019h;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C5962a extends com.tencent.luggage.wxa.wn.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ QRCodeTransferQRDisplayWidget f120021a;

            public C5962a(QRCodeTransferQRDisplayWidget qRCodeTransferQRDisplayWidget) {
                this.f120021a = qRCodeTransferQRDisplayWidget;
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void a() {
                super.a();
                this.f120021a.a(R.id.f650337u);
                this.f120021a.getMAlertIcon().setImageResource(R.drawable.m_u);
                this.f120021a.getMAlertMessage().setText(R.string.f217005zu);
                this.f120021a.getMAlertMessage().setTextColor(Color.parseColor("#FA5151"));
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void b() {
                super.b();
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class b extends com.tencent.luggage.wxa.wn.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ QRCodeTransferQRDisplayWidget f120022a;

            public b(QRCodeTransferQRDisplayWidget qRCodeTransferQRDisplayWidget) {
                this.f120022a = qRCodeTransferQRDisplayWidget;
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void a() {
                super.a();
                this.f120022a.a(R.id.f650337u);
                this.f120022a.getMAlertIcon().setImageResource(R.drawable.m_u);
                this.f120022a.getMAlertMessage().setText(R.string.f217015zv);
                this.f120022a.getMAlertMessage().setTextColor(Color.parseColor("#FA5151"));
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void b() {
                super.b();
            }
        }

        public a() {
            super("Luggage.WXA.Standalone.QRCodeTransferQRDisplayWidget", Looper.getMainLooper());
            d dVar = new d(QRCodeTransferQRDisplayWidget.this, this);
            this.f120015d = dVar;
            c cVar = new c(QRCodeTransferQRDisplayWidget.this);
            this.f120016e = cVar;
            e eVar = new e(QRCodeTransferQRDisplayWidget.this, this);
            this.f120017f = eVar;
            b bVar = new b(QRCodeTransferQRDisplayWidget.this);
            this.f120018g = bVar;
            C5962a c5962a = new C5962a(QRCodeTransferQRDisplayWidget.this);
            this.f120019h = c5962a;
            a((com.tencent.luggage.wxa.wn.b) dVar);
            a((com.tencent.luggage.wxa.wn.b) cVar);
            a((com.tencent.luggage.wxa.wn.b) eVar);
            a((com.tencent.luggage.wxa.wn.b) bVar);
            a((com.tencent.luggage.wxa.wn.b) c5962a);
            b(dVar);
            m();
        }

        @Override // com.tencent.luggage.wxa.wn.c
        public void e(Message message) {
            super.e(message);
            if (message != null && message.what == 10000) {
                a((com.tencent.luggage.wxa.wn.a) this.f120015d);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class d extends com.tencent.luggage.wxa.wn.b {

            /* renamed from: a, reason: collision with root package name */
            public final Lazy f120025a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ QRCodeTransferQRDisplayWidget f120026b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f120027c;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget$a$d$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C5963a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ QRCodeTransferQRDisplayWidget f120028a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C5963a(QRCodeTransferQRDisplayWidget qRCodeTransferQRDisplayWidget) {
                    super(0);
                    this.f120028a = qRCodeTransferQRDisplayWidget;
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final ProgressBar invoke() {
                    return (ProgressBar) this.f120028a.findViewById(R.id.f650637x);
                }
            }

            public d(QRCodeTransferQRDisplayWidget qRCodeTransferQRDisplayWidget, a aVar) {
                Lazy lazy;
                this.f120026b = qRCodeTransferQRDisplayWidget;
                this.f120027c = aVar;
                lazy = LazyKt__LazyJVMKt.lazy(new C5963a(qRCodeTransferQRDisplayWidget));
                this.f120025a = lazy;
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void a() {
                super.a();
                this.f120026b.a(R.id.f650437v);
                c().setVisibility(0);
                Object progressDrawable = c().getProgressDrawable();
                Animatable animatable = progressDrawable instanceof Animatable ? (Animatable) progressDrawable : null;
                if (animatable != null) {
                    animatable.start();
                }
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void b() {
                Animatable animatable;
                super.b();
                c().setVisibility(8);
                Object progressDrawable = c().getProgressDrawable();
                if (progressDrawable instanceof Animatable) {
                    animatable = (Animatable) progressDrawable;
                } else {
                    animatable = null;
                }
                if (animatable != null) {
                    animatable.stop();
                }
            }

            public final ProgressBar c() {
                Object value = this.f120025a.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-mIndicator>(...)");
                return (ProgressBar) value;
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public boolean a(Message message) {
                int i3 = message != null ? message.what : 0;
                if (i3 == 1) {
                    a aVar = this.f120027c;
                    aVar.a((com.tencent.luggage.wxa.wn.a) aVar.f120016e);
                } else if (i3 != 10000) {
                    if (i3 == 3) {
                        a aVar2 = this.f120027c;
                        aVar2.a((com.tencent.luggage.wxa.wn.a) aVar2.f120018g);
                    } else {
                        if (i3 != 4) {
                            return false;
                        }
                        a aVar3 = this.f120027c;
                        aVar3.a((com.tencent.luggage.wxa.wn.a) aVar3.f120019h);
                    }
                }
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class c extends com.tencent.luggage.wxa.wn.b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ QRCodeTransferQRDisplayWidget f120024b;

            public c(QRCodeTransferQRDisplayWidget qRCodeTransferQRDisplayWidget) {
                this.f120024b = qRCodeTransferQRDisplayWidget;
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void a() {
                super.a();
                Object obj = a.this.c().obj;
                Unit unit = null;
                Bitmap bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
                if (bitmap != null) {
                    QRCodeTransferQRDisplayWidget qRCodeTransferQRDisplayWidget = this.f120024b;
                    qRCodeTransferQRDisplayWidget.getMQRImage().setVisibility(0);
                    qRCodeTransferQRDisplayWidget.getMQRImage().setImageBitmap(bitmap);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    a(a.this);
                }
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void b() {
                super.b();
                this.f120024b.getMQRImage().setImageBitmap(null);
                this.f120024b.getMQRImage().setVisibility(4);
            }

            public static final void a(a aVar) {
                w.b("Luggage.WXA.Standalone.QRCodeTransferQRDisplayWidget", "_stateLoaded::enter(), bitmap invalid");
                aVar.a((com.tencent.luggage.wxa.wn.a) aVar.f120019h);
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public boolean a(Message message) {
                int i3 = message != null ? message.what : 0;
                if (i3 == 2) {
                    a aVar = a.this;
                    aVar.a((com.tencent.luggage.wxa.wn.a) aVar.f120017f);
                    return true;
                }
                if (i3 == 3) {
                    a aVar2 = a.this;
                    aVar2.a((com.tencent.luggage.wxa.wn.a) aVar2.f120018g);
                    return true;
                }
                if (i3 != 4) {
                    return false;
                }
                a aVar3 = a.this;
                aVar3.a((com.tencent.luggage.wxa.wn.a) aVar3.f120019h);
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class e extends com.tencent.luggage.wxa.wn.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ QRCodeTransferQRDisplayWidget f120029a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f120030b;

            public e(QRCodeTransferQRDisplayWidget qRCodeTransferQRDisplayWidget, a aVar) {
                this.f120029a = qRCodeTransferQRDisplayWidget;
                this.f120030b = aVar;
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public void a() {
                super.a();
                this.f120029a.a(R.id.f650337u);
                this.f120029a.getMAlertIcon().setImageResource(R.drawable.m_v);
                this.f120029a.getMAlertIcon().getDrawable();
                this.f120029a.getMAlertMessage().setText(R.string.f217025zw);
                this.f120029a.getMAlertMessage().setTextColor(this.f120029a.getResources().getColor(R.color.ap8));
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public boolean a(Message message) {
                int i3 = message != null ? message.what : 0;
                if (i3 == 3) {
                    a aVar = this.f120030b;
                    aVar.a((com.tencent.luggage.wxa.wn.a) aVar.f120018g);
                    return true;
                }
                if (i3 != 4) {
                    return false;
                }
                a aVar2 = this.f120030b;
                aVar2.a((com.tencent.luggage.wxa.wn.a) aVar2.f120019h);
                return true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ImageView invoke() {
            return (ImageView) QRCodeTransferQRDisplayWidget.this.findViewById(R.id.f645836m);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d extends Lambda implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextView invoke() {
            return (TextView) QRCodeTransferQRDisplayWidget.this.findViewById(R.id.f645936n);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements Function0 {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ImageView invoke() {
            return (ImageView) QRCodeTransferQRDisplayWidget.this.findViewById(R.id.f650537w);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRCodeTransferQRDisplayWidget(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff5, this);
        this.DP_142 = Math.round(142 * getContext().getResources().getDisplayMetrics().density);
        this.mLayerIds = new Integer[]{Integer.valueOf(R.id.f650437v), Integer.valueOf(R.id.f650337u)};
        lazy = LazyKt__LazyJVMKt.lazy(new e());
        this.mQRImage = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new c());
        this.mAlertIcon = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new d());
        this.mAlertMessage = lazy3;
        this.mStateMachine = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getMAlertIcon() {
        return (ImageView) this.mAlertIcon.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMAlertMessage() {
        return (TextView) this.mAlertMessage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getMQRImage() {
        return (ImageView) this.mQRImage.getValue();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.DP_142, 1073741824), View.MeasureSpec.makeMeasureSpec(this.DP_142, 1073741824));
    }

    public void b() {
        this.mStateMachine.b(3).sendToTarget();
    }

    public void c() {
        this.mStateMachine.b(2).sendToTarget();
    }

    public final void a(int layerId) {
        for (Integer num : this.mLayerIds) {
            int intValue = num.intValue();
            findViewById(intValue).setVisibility(layerId == intValue ? 0 : 8);
        }
    }

    public void a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.mStateMachine.a(1, bitmap).sendToTarget();
    }

    public void a() {
        this.mStateMachine.b(4).sendToTarget();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRCodeTransferQRDisplayWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff5, this);
        this.DP_142 = Math.round(142 * getContext().getResources().getDisplayMetrics().density);
        this.mLayerIds = new Integer[]{Integer.valueOf(R.id.f650437v), Integer.valueOf(R.id.f650337u)};
        lazy = LazyKt__LazyJVMKt.lazy(new e());
        this.mQRImage = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new c());
        this.mAlertIcon = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new d());
        this.mAlertMessage = lazy3;
        this.mStateMachine = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRCodeTransferQRDisplayWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff5, this);
        this.DP_142 = Math.round(142 * getContext().getResources().getDisplayMetrics().density);
        this.mLayerIds = new Integer[]{Integer.valueOf(R.id.f650437v), Integer.valueOf(R.id.f650337u)};
        lazy = LazyKt__LazyJVMKt.lazy(new e());
        this.mQRImage = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new c());
        this.mAlertIcon = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new d());
        this.mAlertMessage = lazy3;
        this.mStateMachine = new a();
    }

    public void setOnRefreshButtonClickListener(@Nullable View.OnClickListener l3) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public QRCodeTransferQRDisplayWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff5, this);
        this.DP_142 = Math.round(142 * getContext().getResources().getDisplayMetrics().density);
        this.mLayerIds = new Integer[]{Integer.valueOf(R.id.f650437v), Integer.valueOf(R.id.f650337u)};
        lazy = LazyKt__LazyJVMKt.lazy(new e());
        this.mQRImage = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new c());
        this.mAlertIcon = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new d());
        this.mAlertMessage = lazy3;
        this.mStateMachine = new a();
    }
}
