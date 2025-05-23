package com.tencent.aelight.camera.aioeditor.takevideo.mosaic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.QQToastUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00103\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R#\u0010>\u001a\n 9*\u0004\u0018\u000108088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/MosaicLayoutPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lq83/a;", "Landroid/graphics/Bitmap;", TtmlNode.ATTR_TTS_ORIGIN, "T9", "Landroid/view/View;", "v", "", ViewStickEventHelper.IS_SHOW, "", "P9", "U9", "initData", "Y9", "L9", "isDo", MimeHelper.IMAGE_SUBTYPE_BITMAP, "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartStart", NodeProps.ON_CLICK, "onBackEvent", "", "unDoSize", "redoSize", "y4", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mosaicLayout", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mosaicLayoutContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivConfirm", tl.h.F, "ivCancel", "i", "ivUndo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ivRestore", "Lcom/tencent/mobileqq/wink/api/IWinkMosaicLayoutApi;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/api/IWinkMosaicLayoutApi;", "winkMosaicLayoutAPi", "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/h;", "kotlin.jvm.PlatformType", "D", "Lkotlin/Lazy;", "O9", "()Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/h;", "mosaicViewModel", "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;", "E", "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;", "getOnMosaicResultCallback", "()Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;", "X9", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;)V", "onMosaicResultCallback", UserInfo.SEX_FEMALE, "Landroid/graphics/Bitmap;", "cacheOriginBitmap", "<init>", "()V", "G", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MosaicLayoutPart extends Part implements View.OnClickListener, q83.a {

    /* renamed from: G, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static es.a H;

    /* renamed from: C, reason: from kotlin metadata */
    private IWinkMosaicLayoutApi winkMosaicLayoutAPi;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy mosaicViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private IEditPicMosaicOpCallback onMosaicResultCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private Bitmap cacheOriginBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mosaicLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mosaicLayoutContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivConfirm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCancel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivUndo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivRestore;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/MosaicLayoutPart$a;", "", "", "a", "Les/a;", "sStaticCache", "Les/a;", "getSStaticCache", "()Les/a;", "b", "(Les/a;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicLayoutPart$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(es.a aVar) {
            MosaicLayoutPart.H = aVar;
        }

        Companion() {
        }

        public final void a() {
            b(null);
        }
    }

    public MosaicLayoutPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicLayoutPart$mosaicViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return (h) MosaicLayoutPart.this.getViewModel(h.class);
            }
        });
        this.mosaicViewModel = lazy;
    }

    private final boolean J9(boolean isDo, Bitmap bitmap) {
        FragmentActivity activity;
        IEditPicMosaicOpCallback iEditPicMosaicOpCallback = this.onMosaicResultCallback;
        if (iEditPicMosaicOpCallback != null) {
            iEditPicMosaicOpCallback.onMosaicResult(isDo, bitmap);
        }
        Fragment hostFragment = getHostFragment();
        FragmentManager supportFragmentManager = (hostFragment == null || (activity = hostFragment.getActivity()) == null) ? null : activity.getSupportFragmentManager();
        if ((supportFragmentManager != null ? supportFragmentManager.getBackStackEntryCount() : 0) > 0) {
            INSTANCE.a();
            if (supportFragmentManager == null) {
                return true;
            }
            supportFragmentManager.popBackStack();
            return true;
        }
        return super.onBackEvent();
    }

    private final void L9(final View v3) {
        if (this.cacheOriginBitmap == null) {
            K9(this, false, null, 2, null);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.d
                @Override // java.lang.Runnable
                public final void run() {
                    MosaicLayoutPart.M9(MosaicLayoutPart.this, v3);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.graphics.Bitmap] */
    public static final void M9(final MosaicLayoutPart this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "$v");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        IWinkMosaicLayoutApi iWinkMosaicLayoutApi = this$0.winkMosaicLayoutAPi;
        RelativeLayout relativeLayout = null;
        if (iWinkMosaicLayoutApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMosaicLayoutAPi");
            iWinkMosaicLayoutApi = null;
        }
        RelativeLayout relativeLayout2 = this$0.mosaicLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
        } else {
            relativeLayout = relativeLayout2;
        }
        ?? mosaicBitmap = iWinkMosaicLayoutApi.getMosaicBitmap(relativeLayout);
        objectRef.element = mosaicBitmap;
        objectRef.element = com.tencent.biz.qqstory.utils.b.j(this$0.cacheOriginBitmap, mosaicBitmap);
        v3.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.g
            @Override // java.lang.Runnable
            public final void run() {
                MosaicLayoutPart.N9(MosaicLayoutPart.this, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void N9(MosaicLayoutPart this$0, Ref.ObjectRef bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        this$0.J9(true, (Bitmap) bitmap.element);
    }

    private final h O9() {
        return (h) this.mosaicViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(final MosaicLayoutPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IEditPicMosaicOpCallback iEditPicMosaicOpCallback = this$0.onMosaicResultCallback;
        RelativeLayout relativeLayout = null;
        Bitmap originBitmap = iEditPicMosaicOpCallback != null ? iEditPicMosaicOpCallback.getOriginBitmap() : null;
        this$0.cacheOriginBitmap = originBitmap;
        if (originBitmap == null) {
            es.a aVar = H;
            this$0.cacheOriginBitmap = aVar != null ? aVar.getOriginBitmap() : null;
        }
        Bitmap bitmap = this$0.cacheOriginBitmap;
        if (bitmap != null) {
            final Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
            final es.a aVar2 = H;
            if (aVar2 == null) {
                aVar2 = new es.a();
            }
            RelativeLayout relativeLayout2 = this$0.mosaicLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.e
                @Override // java.lang.Runnable
                public final void run() {
                    MosaicLayoutPart.R9(copy, aVar2, this$0);
                }
            });
            aVar2.d(bitmap);
            H = aVar2;
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.f
            @Override // java.lang.Runnable
            public final void run() {
                MosaicLayoutPart.S9(MosaicLayoutPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Bitmap srcBmp, es.a staticCache, MosaicLayoutPart this$0) {
        IWinkMosaicLayoutApi iWinkMosaicLayoutApi;
        RelativeLayout relativeLayout;
        Object obj;
        Intrinsics.checkNotNullParameter(staticCache, "$staticCache");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (srcBmp.isRecycled()) {
            Bitmap originBitmap = staticCache.getOriginBitmap();
            if (originBitmap != null) {
                obj = Boolean.valueOf(originBitmap.isRecycled());
            } else {
                obj = "null";
            }
            QLog.d("EditPicMosaicPart", 1, "[initData] srcBmp is recycled. staticCache.originBitmap=" + obj);
            return;
        }
        IWinkMosaicLayoutApi iWinkMosaicLayoutApi2 = this$0.winkMosaicLayoutAPi;
        if (iWinkMosaicLayoutApi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMosaicLayoutAPi");
            iWinkMosaicLayoutApi = null;
        } else {
            iWinkMosaicLayoutApi = iWinkMosaicLayoutApi2;
        }
        RelativeLayout relativeLayout2 = this$0.mosaicLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
            relativeLayout = null;
        } else {
            relativeLayout = relativeLayout2;
        }
        Intrinsics.checkNotNullExpressionValue(srcBmp, "srcBmp");
        iWinkMosaicLayoutApi.setData(relativeLayout, srcBmp, null, 0.0f, staticCache.c(), staticCache.b());
        this$0.y4(staticCache.c().size(), staticCache.b().size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(MosaicLayoutPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToastUtil.showQQToast(1, R.string.f169887y50);
        K9(this$0, false, null, 2, null);
    }

    private final Bitmap T9(Bitmap origin) {
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(origin, 0, 0, origin.getWidth(), origin.getHeight(), matrix, false);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(origin, 0, \u2026in.height, matrix, false)");
        return createBitmap;
    }

    private final void U9() {
        LiveData<Boolean> M1 = O9().M1();
        Fragment hostFragment = getHostFragment();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicLayoutPart$observerLiveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView;
                MosaicLayoutPart mosaicLayoutPart = MosaicLayoutPart.this;
                imageView = mosaicLayoutPart.ivUndo;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                    imageView = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                mosaicLayoutPart.P9(imageView, it.booleanValue());
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MosaicLayoutPart.V9(Function1.this, obj);
            }
        });
        LiveData<Boolean> L1 = O9().L1();
        Fragment hostFragment2 = getHostFragment();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicLayoutPart$observerLiveData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView;
                MosaicLayoutPart mosaicLayoutPart = MosaicLayoutPart.this;
                imageView = mosaicLayoutPart.ivRestore;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                    imageView = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                mosaicLayoutPart.P9(imageView, it.booleanValue());
            }
        };
        L1.observe(hostFragment2, new Observer() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MosaicLayoutPart.W9(Function1.this, obj);
            }
        });
        IWinkMosaicLayoutApi iWinkMosaicLayoutApi = this.winkMosaicLayoutAPi;
        RelativeLayout relativeLayout = null;
        if (iWinkMosaicLayoutApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMosaicLayoutAPi");
            iWinkMosaicLayoutApi = null;
        }
        RelativeLayout relativeLayout2 = this.mosaicLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
        } else {
            relativeLayout = relativeLayout2;
        }
        iWinkMosaicLayoutApi.setMosaicPaintUpdateCallback(relativeLayout, this);
        Y9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Y9() {
        ImageView imageView = this.ivUndo;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
            imageView = null;
        }
        P9(imageView, O9().O1());
        ImageView imageView3 = this.ivRestore;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
        } else {
            imageView2 = imageView3;
        }
        P9(imageView2, O9().N1());
    }

    private final void initData() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.c
            @Override // java.lang.Runnable
            public final void run() {
                MosaicLayoutPart.Q9(MosaicLayoutPart.this);
            }
        }, 16, null, true);
    }

    public final void X9(IEditPicMosaicOpCallback iEditPicMosaicOpCallback) {
        this.onMosaicResultCallback = iEditPicMosaicOpCallback;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        RelativeLayout relativeLayout = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.rv9) {
            L9(v3);
        } else if (valueOf != null && valueOf.intValue() == R.id.rv8) {
            K9(this, false, null, 2, null);
        } else if (valueOf != null && valueOf.intValue() == R.id.rvh) {
            IWinkMosaicLayoutApi iWinkMosaicLayoutApi = this.winkMosaicLayoutAPi;
            if (iWinkMosaicLayoutApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMosaicLayoutAPi");
                iWinkMosaicLayoutApi = null;
            }
            RelativeLayout relativeLayout2 = this.mosaicLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
            } else {
                relativeLayout = relativeLayout2;
            }
            iWinkMosaicLayoutApi.undo(relativeLayout);
        } else if (valueOf != null && valueOf.intValue() == R.id.rvb) {
            IWinkMosaicLayoutApi iWinkMosaicLayoutApi2 = this.winkMosaicLayoutAPi;
            if (iWinkMosaicLayoutApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMosaicLayoutAPi");
                iWinkMosaicLayoutApi2 = null;
            }
            RelativeLayout relativeLayout3 = this.mosaicLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
            } else {
                relativeLayout = relativeLayout3;
            }
            iWinkMosaicLayoutApi2.redo(relativeLayout);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0110  */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInitView(View rootView) {
        ImageView imageView;
        Drawable drawable;
        Bitmap bitmap;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QRouteApi api = QRoute.api(IWinkMosaicLayoutApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkMosaicLayoutApi::class.java)");
        this.winkMosaicLayoutAPi = (IWinkMosaicLayoutApi) api;
        View findViewById = rootView.findViewById(R.id.rxa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.mosaic_layout_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.mosaicLayoutContainer = frameLayout;
        ImageView imageView6 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mosaicLayoutContainer");
            frameLayout = null;
        }
        if (frameLayout.getChildCount() > 0) {
            FrameLayout frameLayout2 = this.mosaicLayoutContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayoutContainer");
                frameLayout2 = null;
            }
            if (frameLayout2.getChildAt(0) instanceof RelativeLayout) {
                FrameLayout frameLayout3 = this.mosaicLayoutContainer;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mosaicLayoutContainer");
                    frameLayout3 = null;
                }
                View childAt = frameLayout3.getChildAt(0);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.RelativeLayout");
                this.mosaicLayout = (RelativeLayout) childAt;
                View findViewById2 = rootView.findViewById(R.id.rv9);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.ivConfirm)");
                this.ivConfirm = (ImageView) findViewById2;
                View findViewById3 = rootView.findViewById(R.id.rv8);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.ivCancel)");
                this.ivCancel = (ImageView) findViewById3;
                View findViewById4 = rootView.findViewById(R.id.rvh);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.ivUndo)");
                this.ivUndo = (ImageView) findViewById4;
                View findViewById5 = rootView.findViewById(R.id.rvb);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.ivRestore)");
                this.ivRestore = (ImageView) findViewById5;
                imageView = this.ivUndo;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                    imageView = null;
                }
                drawable = imageView.getDrawable();
                if (!(drawable instanceof SkinnableBitmapDrawable)) {
                    bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                } else {
                    bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
                }
                if (bitmap != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(rootView.getResources(), T9(bitmap));
                    bitmapDrawable.setTint(rootView.getResources().getColor(R.color.qui_common_icon_white));
                    ImageView imageView7 = this.ivRestore;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                        imageView7 = null;
                    }
                    imageView7.setImageDrawable(bitmapDrawable);
                }
                imageView2 = this.ivConfirm;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivConfirm");
                    imageView2 = null;
                }
                imageView2.setOnClickListener(this);
                imageView3 = this.ivCancel;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivCancel");
                    imageView3 = null;
                }
                imageView3.setOnClickListener(this);
                imageView4 = this.ivUndo;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                    imageView4 = null;
                }
                imageView4.setOnClickListener(this);
                imageView5 = this.ivRestore;
                if (imageView5 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                } else {
                    imageView6 = imageView5;
                }
                imageView6.setOnClickListener(this);
                U9();
            }
        }
        FrameLayout frameLayout4 = this.mosaicLayoutContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mosaicLayoutContainer");
            frameLayout4 = null;
        }
        if (frameLayout4.getChildCount() > 0) {
            FrameLayout frameLayout5 = this.mosaicLayoutContainer;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayoutContainer");
                frameLayout5 = null;
            }
            frameLayout5.removeAllViews();
        }
        IWinkMosaicLayoutApi iWinkMosaicLayoutApi = this.winkMosaicLayoutAPi;
        if (iWinkMosaicLayoutApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMosaicLayoutAPi");
            iWinkMosaicLayoutApi = null;
        }
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.mosaicLayout = iWinkMosaicLayoutApi.getMosaicLayout(context, null);
        FrameLayout frameLayout6 = this.mosaicLayoutContainer;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mosaicLayoutContainer");
            frameLayout6 = null;
        }
        RelativeLayout relativeLayout = this.mosaicLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
            relativeLayout = null;
        }
        frameLayout6.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        View findViewById22 = rootView.findViewById(R.id.rv9);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "rootView.findViewById(R.id.ivConfirm)");
        this.ivConfirm = (ImageView) findViewById22;
        View findViewById32 = rootView.findViewById(R.id.rv8);
        Intrinsics.checkNotNullExpressionValue(findViewById32, "rootView.findViewById(R.id.ivCancel)");
        this.ivCancel = (ImageView) findViewById32;
        View findViewById42 = rootView.findViewById(R.id.rvh);
        Intrinsics.checkNotNullExpressionValue(findViewById42, "rootView.findViewById(R.id.ivUndo)");
        this.ivUndo = (ImageView) findViewById42;
        View findViewById52 = rootView.findViewById(R.id.rvb);
        Intrinsics.checkNotNullExpressionValue(findViewById52, "rootView.findViewById(R.id.ivRestore)");
        this.ivRestore = (ImageView) findViewById52;
        imageView = this.ivUndo;
        if (imageView == null) {
        }
        drawable = imageView.getDrawable();
        if (!(drawable instanceof SkinnableBitmapDrawable)) {
        }
        if (bitmap != null) {
        }
        imageView2 = this.ivConfirm;
        if (imageView2 == null) {
        }
        imageView2.setOnClickListener(this);
        imageView3 = this.ivCancel;
        if (imageView3 == null) {
        }
        imageView3.setOnClickListener(this);
        imageView4 = this.ivUndo;
        if (imageView4 == null) {
        }
        imageView4.setOnClickListener(this);
        imageView5 = this.ivRestore;
        if (imageView5 != null) {
        }
        imageView6.setOnClickListener(this);
        U9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
        initData();
    }

    @Override // q83.a
    public void y4(int unDoSize, int redoSize) {
        O9().P1(unDoSize, redoSize);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        return K9(this, false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(View v3, boolean isShow) {
        if (isShow) {
            v3.setAlpha(1.0f);
            v3.setClickable(true);
        } else {
            v3.setAlpha(0.4f);
            v3.setClickable(false);
        }
    }

    static /* synthetic */ boolean K9(MosaicLayoutPart mosaicLayoutPart, boolean z16, Bitmap bitmap, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bitmap = null;
        }
        return mosaicLayoutPart.J9(z16, bitmap);
    }
}
