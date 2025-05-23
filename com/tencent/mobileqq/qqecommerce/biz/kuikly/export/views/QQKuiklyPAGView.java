package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import d01.PAGReplaceItem;
import d01.s;
import d01.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGText;
import org.libpag.PAGTextLayer;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001,\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0017J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0017J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010)R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyPAGView;", "Landroid/widget/FrameLayout;", "Ld01/s;", "", ReportConstant.COSTREPORT_PREFIX, "Ld01/x;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lkotlin/Function0;", "block", "r", "f", "i", "", "layerName", "filePath", "b", "text", "c", "", "items", "g", "setFilePath", "", "count", "setPAGViewRepeatCount", "Ld01/t;", "listener", tl.h.F, "e", "Landroid/view/View;", "d", "Lorg/libpag/PAGView;", "Lorg/libpag/PAGView;", "pagView", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/PAGSoLoader;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/PAGSoLoader;", "pagSoLoader", "", "Ljava/util/List;", "listeners", "replaceList", "com/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyPAGView$b", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyPAGView$b;", "pagViewListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyPAGView extends FrameLayout implements s {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PAGView pagView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final PAGSoLoader pagSoLoader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<t> listeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<PAGReplaceItem> replaceList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b pagViewListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyPAGView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagSoLoader = new PAGSoLoader();
        this.listeners = new ArrayList();
        this.replaceList = new ArrayList();
        this.pagViewListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(PAGReplaceItem item) {
        int type = item.getType();
        if (type == 0) {
            q(item);
        } else {
            if (type != 1) {
                return;
            }
            p(item);
        }
    }

    private final void p(PAGReplaceItem item) {
        PAGImage FromBitmap;
        String replace$default;
        PAGView pAGView = this.pagView;
        PAGComposition composition = pAGView != null ? pAGView.getComposition() : null;
        if (composition == null) {
            return;
        }
        String layerName = item.getLayerName();
        Integer layerIndex = item.getLayerIndex();
        String imageFilePath = item.getImageFilePath();
        String imageFileAsset = item.getImageFileAsset();
        Bitmap imageBitmap = item.getImageBitmap();
        if (imageFilePath != null) {
            FromBitmap = PAGImage.FromPath(imageFilePath);
        } else if (imageFileAsset != null) {
            AssetManager assets = getContext().getAssets();
            replace$default = StringsKt__StringsJVMKt.replace$default(imageFileAsset, "assets://", "", false, 4, (Object) null);
            FromBitmap = PAGImage.FromAssets(assets, replace$default);
        } else {
            FromBitmap = imageBitmap != null ? PAGImage.FromBitmap(imageBitmap) : null;
            if (FromBitmap == null) {
                return;
            }
        }
        if (layerName == null) {
            if (layerIndex != null) {
                PAGFile pAGFile = composition instanceof PAGFile ? (PAGFile) composition : null;
                if (pAGFile != null && layerIndex.intValue() < pAGFile.numImages()) {
                    pAGFile.replaceImage(layerIndex.intValue(), FromBitmap);
                    return;
                }
                return;
            }
            return;
        }
        PAGLayer[] layersByName = composition.getLayersByName(layerName);
        Intrinsics.checkNotNullExpressionValue(layersByName, "composition.getLayersByName(layerName)");
        ArrayList arrayList = new ArrayList();
        for (PAGLayer pAGLayer : layersByName) {
            if (pAGLayer instanceof PAGImageLayer) {
                arrayList.add(pAGLayer);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageLayer) it.next()).setImage(FromBitmap);
        }
    }

    private final void q(PAGReplaceItem item) {
        String text;
        PAGView pAGView = this.pagView;
        PAGComposition composition = pAGView != null ? pAGView.getComposition() : null;
        if (composition == null || (text = item.getText()) == null) {
            return;
        }
        String layerName = item.getLayerName();
        Integer layerIndex = item.getLayerIndex();
        if (layerName == null) {
            if (layerIndex != null) {
                PAGFile pAGFile = composition instanceof PAGFile ? (PAGFile) composition : null;
                if (pAGFile != null && layerIndex.intValue() < pAGFile.numTexts()) {
                    PAGText textData = pAGFile.getTextData(layerIndex.intValue());
                    textData.text = text;
                    pAGFile.replaceText(layerIndex.intValue(), textData);
                    return;
                }
                return;
            }
            return;
        }
        PAGLayer[] layersByName = composition.getLayersByName(layerName);
        Intrinsics.checkNotNullExpressionValue(layersByName, "composition.getLayersByName(layerName)");
        ArrayList arrayList = new ArrayList();
        for (PAGLayer pAGLayer : layersByName) {
            if (pAGLayer instanceof PAGTextLayer) {
                arrayList.add(pAGLayer);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGTextLayer) it.next()).setText(text);
        }
    }

    private final void r(final Function0<Unit> block) {
        if (this.pagView != null) {
            block.invoke();
        } else {
            this.pagSoLoader.m(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPAGView$ensurePagViewReady$1
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

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PAGView pAGView;
                    pAGView = QQKuiklyPAGView.this.pagView;
                    if (pAGView == null) {
                        QQKuiklyPAGView.this.s();
                        block.invoke();
                    } else {
                        block.invoke();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        if (this.pagView != null) {
            return;
        }
        PAGView pAGView = new PAGView(getContext());
        pAGView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(pAGView);
        pAGView.addListener(this.pagViewListener);
        this.pagView = pAGView;
        QLog.d("QQKuiklyPAGView", 1, "init pag view done: " + hashCode());
    }

    @Override // d01.s
    public boolean a(String str, Object obj) {
        return s.a.a(this, str, obj);
    }

    @Override // d01.s
    @Deprecated(message = "use replaceLayerContents instead", replaceWith = @ReplaceWith(expression = "replaceLayerContents(items)", imports = {}))
    public void b(final String layerName, final String filePath) {
        Intrinsics.checkNotNullParameter(layerName, "layerName");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        final WeakReference weakReference = new WeakReference(this);
        r(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPAGView$replaceImageLayerContent$1
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean startsWith$default;
                PAGReplaceItem pAGReplaceItem;
                List list;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(filePath, "assets://", false, 2, null);
                if (startsWith$default) {
                    String str = layerName;
                    String substring = filePath.substring(9);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    pAGReplaceItem = new PAGReplaceItem(1, str, null, null, null, substring, null, 92, null);
                } else {
                    pAGReplaceItem = new PAGReplaceItem(1, layerName, null, null, filePath, null, null, 108, null);
                }
                QQKuiklyPAGView qQKuiklyPAGView = weakReference.get();
                if (qQKuiklyPAGView != null) {
                    list = qQKuiklyPAGView.replaceList;
                    list.add(pAGReplaceItem);
                    qQKuiklyPAGView.o(pAGReplaceItem);
                }
            }
        });
    }

    @Override // d01.s
    @Deprecated(message = "use replaceLayerContents instead", replaceWith = @ReplaceWith(expression = "replaceLayerContents(items)", imports = {}))
    public void c(final String layerName, final String text) {
        Intrinsics.checkNotNullParameter(layerName, "layerName");
        Intrinsics.checkNotNullParameter(text, "text");
        final WeakReference weakReference = new WeakReference(this);
        r(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPAGView$replaceTextLayerContent$1
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                PAGReplaceItem pAGReplaceItem = new PAGReplaceItem(0, layerName, null, text, null, null, null, 116, null);
                QQKuiklyPAGView qQKuiklyPAGView = weakReference.get();
                if (qQKuiklyPAGView != null) {
                    list = qQKuiklyPAGView.replaceList;
                    list.add(pAGReplaceItem);
                    qQKuiklyPAGView.o(pAGReplaceItem);
                }
            }
        });
    }

    @Override // d01.s
    public void e(t listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            this.listeners.remove(listener);
        }
    }

    @Override // d01.s
    public void f() {
        r(new QQKuiklyPAGView$playPAGView$1(new WeakReference(this)));
    }

    @Override // d01.s
    public void g(final List<PAGReplaceItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        final WeakReference weakReference = new WeakReference(this);
        r(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPAGView$replaceLayerContents$1
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                QQKuiklyPAGView qQKuiklyPAGView = weakReference.get();
                if (qQKuiklyPAGView != null) {
                    List<PAGReplaceItem> list2 = items;
                    list = qQKuiklyPAGView.replaceList;
                    list.addAll(list2);
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        qQKuiklyPAGView.o((PAGReplaceItem) it.next());
                    }
                }
            }
        });
    }

    @Override // d01.s
    public void h(t listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            this.listeners.add(listener);
        }
    }

    @Override // d01.s
    public void i() {
        r(new QQKuiklyPAGView$stopPAGView$1(new WeakReference(this)));
    }

    @Override // d01.s
    public void setFilePath(final String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        final WeakReference weakReference = new WeakReference(this);
        r(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPAGView$setFilePath$1
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PAGView pAGView;
                List list;
                QQKuiklyPAGView qQKuiklyPAGView = weakReference.get();
                if (qQKuiklyPAGView != null) {
                    String str = filePath;
                    pAGView = qQKuiklyPAGView.pagView;
                    if (pAGView != null) {
                        pAGView.setPath(str);
                    }
                    list = qQKuiklyPAGView.replaceList;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        qQKuiklyPAGView.o((PAGReplaceItem) it.next());
                    }
                }
            }
        });
    }

    @Override // d01.s
    public void setPAGViewRepeatCount(final int count) {
        final WeakReference weakReference = new WeakReference(this);
        r(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPAGView$setPAGViewRepeatCount$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
            
                r0 = r0.pagView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                PAGView pAGView;
                QQKuiklyPAGView qQKuiklyPAGView = weakReference.get();
                if (qQKuiklyPAGView == null || pAGView == null) {
                    return;
                }
                pAGView.setRepeatCount(count);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyPAGView$b", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "view", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements PAGView.PAGViewListener {
        b() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView view) {
            if (view == null) {
                return;
            }
            List list = QQKuiklyPAGView.this.listeners;
            QQKuiklyPAGView qQKuiklyPAGView = QQKuiklyPAGView.this;
            synchronized (list) {
                Iterator it = qQKuiklyPAGView.listeners.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).onAnimationCancel(view);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView view) {
            if (view == null) {
                return;
            }
            List list = QQKuiklyPAGView.this.listeners;
            QQKuiklyPAGView qQKuiklyPAGView = QQKuiklyPAGView.this;
            synchronized (list) {
                Iterator it = qQKuiklyPAGView.listeners.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).onAnimationEnd(view);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView view) {
            if (view == null) {
                return;
            }
            List list = QQKuiklyPAGView.this.listeners;
            QQKuiklyPAGView qQKuiklyPAGView = QQKuiklyPAGView.this;
            synchronized (list) {
                Iterator it = qQKuiklyPAGView.listeners.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).a(view);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView view) {
            if (view == null) {
                return;
            }
            List list = QQKuiklyPAGView.this.listeners;
            QQKuiklyPAGView qQKuiklyPAGView = QQKuiklyPAGView.this;
            synchronized (list) {
                Iterator it = qQKuiklyPAGView.listeners.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).onAnimationStart(view);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView view) {
        }
    }

    @Override // d01.s
    public View d() {
        return this;
    }
}
