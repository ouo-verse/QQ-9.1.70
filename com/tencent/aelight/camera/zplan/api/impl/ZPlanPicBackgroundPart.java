package com.tencent.aelight.camera.zplan.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.zplan.api.impl.b;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001CB\u000f\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\"\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\"\u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\"0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00106\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R(\u0010=\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001078\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006D"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanPicBackgroundPart;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/u;", "Lcom/tencent/aelight/camera/zplan/api/impl/e;", "", "l0", "()Lkotlin/Unit;", "", "colorInt", "r0", "o0", "", "path", "s0", "(Ljava/lang/String;)Lkotlin/Unit;", "Landroid/graphics/RectF;", "dstRect", "Lcom/tencent/aelight/camera/zplan/api/impl/b$b;", "p0", "n0", "onCreate", "editVideoStateOld", "editVideoStateNew", "", "extra", "editVideoStateChanged", "fragmentIndex", "Lfs/b;", "generateContext", "editVideoPrePublish", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/aelight/camera/zplan/api/impl/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a0", "Landroid/support/v7/widget/RecyclerView;", "d", "Landroid/support/v7/widget/RecyclerView;", "backgroundSelectList", "Lcom/tencent/aelight/camera/zplan/api/impl/c;", "e", "Lcom/tencent/aelight/camera/zplan/api/impl/c;", "backgroundListAdapter", "", "f", "Ljava/util/List;", "backgroundSelections", "Landroid/widget/RelativeLayout;", tl.h.F, "Lkotlin/Lazy;", "m0", "()Landroid/widget/RelativeLayout;", "previewContainer", "Lcom/tencent/aelight/camera/zplan/api/impl/b;", "value", "i", "Lcom/tencent/aelight/camera/zplan/api/impl/b;", "q0", "(Lcom/tencent/aelight/camera/zplan/api/impl/b;)V", "background", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;", "manager", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ZPlanPicBackgroundPart extends u implements e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView backgroundSelectList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.zplan.api.impl.c backgroundListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<f> backgroundSelections;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy previewContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.zplan.api.impl.b background;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aelight/camera/zplan/api/impl/ZPlanPicBackgroundPart$b", "Lcom/tencent/aelight/camera/zplan/api/impl/l;", "Lcom/tencent/aelight/camera/zplan/api/impl/b;", "getBackground", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements l {
        b() {
        }

        @Override // com.tencent.aelight.camera.zplan.api.impl.l
        public com.tencent.aelight.camera.zplan.api.impl.b getBackground() {
            return ZPlanPicBackgroundPart.this.background;
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/aelight/camera/zplan/api/impl/ZPlanPicBackgroundPart$c", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "normalPadding", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int normalPadding;

        c(RecyclerView recyclerView) {
            this.normalPadding = UIUtils.b(recyclerView.getContext(), 15.0f);
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.left = this.normalPadding;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPicBackgroundPart(EditVideoPartManager manager) {
        super(manager);
        List<f> listOf;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(manager, "manager");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{i.f69106a, new ColorPreset(-1), new ColorPreset(SupportMenu.CATEGORY_MASK), new ColorPreset(-256), new ColorPreset(-16711936), new ColorPreset(-16776961), new ColorPreset(Color.parseColor("#8975FF")), new ColorPreset(-65281)});
        this.backgroundSelections = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.aelight.camera.zplan.api.impl.ZPlanPicBackgroundPart$previewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                View findViewSure;
                findViewSure = ZPlanPicBackgroundPart.this.findViewSure(R.id.rsn);
                if (findViewSure instanceof RelativeLayout) {
                    return (RelativeLayout) findViewSure;
                }
                return null;
            }
        });
        this.previewContainer = lazy;
    }

    private final Unit l0() {
        Drawable colorDrawable;
        com.tencent.aelight.camera.zplan.api.impl.b bVar = this.background;
        if (bVar == null) {
            return null;
        }
        if (bVar instanceof b.PicBackground) {
            colorDrawable = new BitmapDrawable(getResources(), ((b.PicBackground) bVar).getBackgroundPic());
        } else if (bVar instanceof b.ColorBackground) {
            colorDrawable = new ColorDrawable(((b.ColorBackground) bVar).getColorInt());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        RelativeLayout m06 = m0();
        if (m06 != null) {
            m06.setBackground(colorDrawable);
        }
        return Unit.INSTANCE;
    }

    private final RelativeLayout m0() {
        return (RelativeLayout) this.previewContainer.getValue();
    }

    private final void n0() {
        this.backgroundListAdapter = new com.tencent.aelight.camera.zplan.api.impl.c(this, this.backgroundSelections);
        RecyclerView recyclerView = new RecyclerView(this.mUi.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mUi.getContext(), 0, false));
        com.tencent.aelight.camera.zplan.api.impl.c cVar = this.backgroundListAdapter;
        RecyclerView recyclerView2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundListAdapter");
            cVar = null;
        }
        recyclerView.setAdapter(cVar);
        recyclerView.addItemDecoration(new c(recyclerView));
        recyclerView.setVisibility(8);
        this.backgroundSelectList = recyclerView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(30.0f), 0, 0);
        layoutParams.addRule(2, R.id.rpz);
        View findViewSure = findViewSure(R.id.rpy);
        RelativeLayout relativeLayout = findViewSure instanceof RelativeLayout ? (RelativeLayout) findViewSure : null;
        if (relativeLayout != null) {
            RecyclerView recyclerView3 = this.backgroundSelectList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectList");
            } else {
                recyclerView2 = recyclerView3;
            }
            relativeLayout.addView(recyclerView2, layoutParams);
        }
    }

    private final void o0() {
        Navigator withString = QRoute.createNavigator(this.mUi.getContext(), IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI).withString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, Reflection.getOrCreateKotlinClass(PhotoListCustomizationZPlan.class).getQualifiedName());
        Activity activity = this.mUi.getActivity();
        if (activity == null) {
            return;
        }
        Navigator.withRequestCode$default(withString, activity, 4000, (Bundle) null, 4, (Object) null).requestWithReturn();
    }

    private final b.PicBackground p0(String path, RectF dstRect) {
        Bitmap d16;
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(path);
        if (decodeFile == null) {
            return null;
        }
        d16 = n.d(decodeFile, dstRect);
        return new b.PicBackground(d16);
    }

    private final void q0(com.tencent.aelight.camera.zplan.api.impl.b bVar) {
        this.background = bVar;
        l0();
    }

    private final void r0(int colorInt) {
        q0(new b.ColorBackground(colorInt));
    }

    private final Unit s0(String path) {
        RectF c16;
        RelativeLayout m06 = m0();
        if (m06 == null) {
            return null;
        }
        c16 = n.c(m06);
        q0(p0(path, c16));
        return Unit.INSTANCE;
    }

    @Override // com.tencent.aelight.camera.zplan.api.impl.e
    public void a0(f item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof i) {
            o0();
        } else {
            if (item instanceof ColorPreset) {
                r0(((ColorPreset) item).getColorInt());
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int fragmentIndex, fs.b generateContext) {
        Intrinsics.checkNotNullParameter(generateContext, "generateContext");
        publishEditExport(l.class, new b());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        n0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int editVideoStateOld, int editVideoStateNew, Object extra) {
        RecyclerView recyclerView = null;
        if (editVideoStateOld == 4000) {
            QLog.i("ZPlanPicBackgroundPart", 1, "exit background edit");
            RecyclerView recyclerView2 = this.backgroundSelectList;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectList");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        if (editVideoStateNew == 4000) {
            QLog.i("ZPlanPicBackgroundPart", 1, "start background edit");
            RecyclerView recyclerView3 = this.backgroundSelectList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectList");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(0);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String[] stringArrayExtra;
        Object firstOrNull;
        if (resultCode != -1 || requestCode != 4000 || data == null || (stringArrayExtra = data.getStringArrayExtra("PhotoConst.PHOTO_PATHS")) == null) {
            return;
        }
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(stringArrayExtra);
        String str = (String) firstOrNull;
        if (str != null) {
            s0(str);
        }
    }
}
