package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001cR\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010$R\u0016\u00103\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010$R+\u0010;\u001a\u0002042\u0006\u00105\u001a\u0002048B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b$\u00108\"\u0004\b9\u0010:R+\u0010?\u001a\u0002042\u0006\u00105\u001a\u0002048B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/kuikly/core/views/ImageSpan;", "Lcom/tencent/kuikly/core/views/bg;", "Lcom/tencent/kuikly/core/base/attr/b;", "", "width", "height", "I", "", "src", "", "isDotNineImage", "e", "Lcom/tencent/kuikly/core/base/attr/e;", LayoutAttrDefine.CLICK_URI, "b", "", "d", "Lcom/tencent/kuikly/core/views/RichTextView;", "richTextView", "D", "a", "Lcom/tencent/kuikly/core/base/event/c;", "clickParams", "c", "Lcom/tencent/kuikly/core/base/w;", "Lcom/tencent/kuikly/core/base/w;", "size", "f", "Ljava/lang/String;", "g", "Lcom/tencent/kuikly/core/base/attr/e;", tl.h.F, "placeholder", "i", NodeProps.RESIZE_MODE, "j", UserInfo.SEX_FEMALE, "blurRadius", "Lcom/tencent/kuikly/core/base/h;", "k", "Lcom/tencent/kuikly/core/base/h;", "tintColor", "", "l", "[F", CustomAnimation.KeyPath.COLOR_FILTER, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", DomainData.DOMAIN_NAME, NodeProps.BORDER_RADIUS, "o", "verticalAlignOffset", "Lcom/tencent/kuikly/core/layout/d;", "<set-?>", "p", "Lkotlin/properties/ReadWriteProperty;", "()Lcom/tencent/kuikly/core/layout/d;", "H", "(Lcom/tencent/kuikly/core/layout/d;)V", "richTextFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "G", "placeholderFrame", "Lcom/tencent/kuikly/core/views/ImageView;", "r", "Lcom/tencent/kuikly/core/views/ImageView;", "view", "Lkotlin/Function1;", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/jvm/functions/Function1;", "clickHandlerFn", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ImageSpan extends bg implements com.tencent.kuikly.core.base.attr.b {

    /* renamed from: t, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118295t = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ImageSpan.class, "richTextFrame", "getRichTextFrame()Lcom/tencent/kuikly/core/layout/Frame;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ImageSpan.class, "placeholderFrame", "getPlaceholderFrame()Lcom/tencent/kuikly/core/layout/Frame;", 0))};

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.attr.e uri;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float blurRadius;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.h tintColor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float[] colorFilter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isDotNineImage;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float borderRadius;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float verticalAlignOffset;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty richTextFrame;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty placeholderFrame;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ImageView view;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ClickParams, Unit> clickHandlerFn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.w size = new com.tencent.kuikly.core.base.w(0.0f, 0.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String src = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String placeholder = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String resizeMode = "";

    public ImageSpan() {
        d.Companion companion = com.tencent.kuikly.core.layout.d.INSTANCE;
        this.richTextFrame = c01.c.a(companion.a());
        this.placeholderFrame = c01.c.a(companion.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.kuikly.core.layout.d E() {
        return (com.tencent.kuikly.core.layout.d) this.placeholderFrame.getValue(this, f118295t[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.kuikly.core.layout.d F() {
        return (com.tencent.kuikly.core.layout.d) this.richTextFrame.getValue(this, f118295t[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(com.tencent.kuikly.core.layout.d dVar) {
        this.placeholderFrame.setValue(this, f118295t[1], dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(com.tencent.kuikly.core.layout.d dVar) {
        this.richTextFrame.setValue(this, f118295t[0], dVar);
    }

    public final void D(final RichTextView richTextView) {
        Intrinsics.checkNotNullParameter(richTextView, "richTextView");
        i(this.size.getWidth(), this.size.getHeight());
        k(new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.kuikly.core.views.ImageSpan$build$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.layout.d frame) {
                Intrinsics.checkNotNullParameter(frame, "frame");
                ImageSpan.this.G(frame);
            }
        });
        H(richTextView.getFlexNode().getLayoutFrame());
        richTextView.event(new Function1<RichTextEvent, Unit>() { // from class: com.tencent.kuikly.core.views.ImageSpan$build$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RichTextEvent richTextEvent) {
                invoke2(richTextEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RichTextEvent event) {
                Intrinsics.checkNotNullParameter(event, "$this$event");
                final ImageSpan imageSpan = ImageSpan.this;
                FrameEventKt.a(event, new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.kuikly.core.views.ImageSpan$build$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                        invoke2(dVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.kuikly.core.layout.d frame) {
                        Intrinsics.checkNotNullParameter(frame, "frame");
                        ImageSpan.this.H(frame);
                    }
                });
            }
        });
        ReactiveObserver.INSTANCE.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.ImageSpan$build$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
            
                r1 = r2.view;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ImageView imageView;
                ViewContainer<?, ?> parent = RichTextView.this.getParent();
                while (true) {
                    boolean z16 = false;
                    if (parent != null && VirtualViewKt.b(parent)) {
                        z16 = true;
                    }
                    if (!z16) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (parent != null) {
                    ImageView imageView2 = new ImageView();
                    final ImageSpan imageSpan = this;
                    final ImageSpan imageSpan2 = this;
                    parent.addChild(imageView2, new Function1<ImageView, Unit>() { // from class: com.tencent.kuikly.core.views.ImageSpan$build$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView3) {
                            invoke2(imageView3);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ImageView addChild) {
                            Function1<? super ClickParams, Unit> function1;
                            Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                            ImageSpan.this.view = addChild;
                            final ImageSpan imageSpan3 = imageSpan2;
                            final ImageSpan imageSpan4 = ImageSpan.this;
                            addChild.attr(new Function1<af, Unit>() { // from class: com.tencent.kuikly.core.views.ImageSpan.build.3.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(af afVar) {
                                    invoke2(afVar);
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:4:0x006b, code lost:
                                
                                    if (r10.b(r0, r1) == null) goto L6;
                                 */
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke2(af attr) {
                                    com.tencent.kuikly.core.layout.d F;
                                    com.tencent.kuikly.core.layout.d E;
                                    float f16;
                                    com.tencent.kuikly.core.layout.d F2;
                                    com.tencent.kuikly.core.layout.d E2;
                                    com.tencent.kuikly.core.base.w wVar;
                                    com.tencent.kuikly.core.base.w wVar2;
                                    com.tencent.kuikly.core.base.attr.e eVar;
                                    String str;
                                    boolean z17;
                                    String str2;
                                    float f17;
                                    com.tencent.kuikly.core.base.h hVar;
                                    float[] fArr;
                                    String str3;
                                    float f18;
                                    String str4;
                                    float f19;
                                    boolean z18;
                                    Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                    F = ImageSpan.this.F();
                                    float y16 = F.getY();
                                    E = ImageSpan.this.E();
                                    float y17 = y16 + E.getY();
                                    f16 = imageSpan4.verticalAlignOffset;
                                    float f26 = y17 + f16;
                                    F2 = ImageSpan.this.F();
                                    float x16 = F2.getX();
                                    E2 = ImageSpan.this.E();
                                    Attr.absolutePosition$default(attr, f26, x16 + E2.getX(), 0.0f, 0.0f, 12, null);
                                    wVar = ImageSpan.this.size;
                                    float width = wVar.getWidth();
                                    wVar2 = ImageSpan.this.size;
                                    attr.size(width, wVar2.getHeight());
                                    eVar = ImageSpan.this.uri;
                                    if (eVar != null) {
                                        z18 = ImageSpan.this.isDotNineImage;
                                    }
                                    str = ImageSpan.this.src;
                                    z17 = ImageSpan.this.isDotNineImage;
                                    attr.e(str, z17);
                                    str2 = ImageSpan.this.resizeMode;
                                    int hashCode = str2.hashCode();
                                    if (hashCode != -1881872635) {
                                        if (hashCode != 94852023) {
                                            if (hashCode == 951526612 && str2.equals(HVideoConstants.ResizeType.RESIZE_CONTAIN)) {
                                                attr.o();
                                            }
                                        } else if (str2.equals("cover")) {
                                            attr.p();
                                        }
                                    } else if (str2.equals("stretch")) {
                                        attr.q();
                                    }
                                    f17 = ImageSpan.this.blurRadius;
                                    if (f17 > 0.0f) {
                                        f19 = ImageSpan.this.blurRadius;
                                        attr.h(f19);
                                    }
                                    hVar = imageSpan4.tintColor;
                                    if (hVar != null) {
                                        attr.t(hVar);
                                    }
                                    fArr = imageSpan4.colorFilter;
                                    if (fArr != null) {
                                        attr.i(fArr);
                                    }
                                    str3 = ImageSpan.this.placeholder;
                                    if (str3.length() > 0) {
                                        str4 = ImageSpan.this.placeholder;
                                        attr.n(str4);
                                    }
                                    f18 = ImageSpan.this.borderRadius;
                                    attr.borderRadius(f18);
                                }
                            });
                            function1 = ImageSpan.this.clickHandlerFn;
                            if (function1 != null) {
                                ((ImageEvent) addChild.getViewEvent()).click(function1);
                            }
                        }
                    });
                }
                if (parent == null || imageView == null) {
                    return;
                }
                parent.insertDomSubView(imageView, VirtualViewKt.a(parent).indexOf(imageView));
            }
        });
    }

    public final com.tencent.kuikly.core.base.attr.b I(float width, float height) {
        this.size = new com.tencent.kuikly.core.base.w(width, height);
        return this;
    }

    @Override // com.tencent.kuikly.core.views.bg, com.tencent.kuikly.core.views.ae
    public boolean a() {
        return this.clickHandlerFn != null;
    }

    @Override // com.tencent.kuikly.core.base.attr.b
    public com.tencent.kuikly.core.base.attr.b b(com.tencent.kuikly.core.base.attr.e uri, boolean isDotNineImage) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.isDotNineImage = isDotNineImage;
        this.src = "";
        return this;
    }

    @Override // com.tencent.kuikly.core.views.bg, com.tencent.kuikly.core.views.ae
    public boolean c(ClickParams clickParams) {
        Intrinsics.checkNotNullParameter(clickParams, "clickParams");
        Function1<? super ClickParams, Unit> function1 = this.clickHandlerFn;
        if (function1 != null) {
            function1.invoke(clickParams);
        }
        return this.clickHandlerFn != null;
    }

    @Override // com.tencent.kuikly.core.views.bg, com.tencent.kuikly.core.views.ae
    public void d() {
        ViewContainer<?, ?> parent;
        DeclarativeBaseView<?, ?> declarativeBaseView = this.view;
        if (declarativeBaseView != null && (parent = declarativeBaseView.getParent()) != null) {
            parent.removeDomSubView(declarativeBaseView);
            parent.removeChild(declarativeBaseView);
        }
        this.view = null;
    }

    @Override // com.tencent.kuikly.core.base.attr.b
    public com.tencent.kuikly.core.base.attr.b e(String src, boolean isDotNineImage) {
        Intrinsics.checkNotNullParameter(src, "src");
        this.src = src;
        this.isDotNineImage = isDotNineImage;
        this.uri = null;
        return this;
    }
}
