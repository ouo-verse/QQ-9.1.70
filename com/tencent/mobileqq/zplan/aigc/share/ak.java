package com.tencent.mobileqq.zplan.aigc.share;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.zplan.aigc.share.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001\"B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010&\u0012\u0006\u0010+\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\bF\u0010GJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J+\u0010\u001a\u001a\u00020\r2\u001c\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u0017j\b\u0012\u0004\u0012\u00020\t`\u00180\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0007H\u0014J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0012\u0010\"\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\rH\u0016R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u0010R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u0010>\u001a\u0002082\u0006\u00109\u001a\u0002088\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/ak;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "Lcom/tencent/mobileqq/zplan/aigc/share/h;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "v0", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "x0", "", "I", "Lcom/tencent/mobileqq/zplan/aigc/share/g;", "presenter", "z0", "", "isShowing", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "items", "y0", "([Ljava/util/ArrayList;)V", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/aigc/share/c;", "genPosterCallback", "u0", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "a", "show", "J0", "Lcom/tencent/mobileqq/zplan/aigc/share/g;", "Lzd3/a;", "K0", "Lzd3/a;", "dtReporter", "L0", "gender", "", "M0", "Ljava/lang/String;", "source", "Landroid/widget/LinearLayout;", "N0", "Landroid/widget/LinearLayout;", "actionSheetLayout", "Lmqq/util/WeakReference;", "O0", "Lmqq/util/WeakReference;", "mWeakActivity", "Landroid/view/ViewGroup;", "<set-?>", "P0", "Landroid/view/ViewGroup;", "w0", "()Landroid/view/ViewGroup;", "mSharePictureLayout", "Q0", "Landroid/view/View;", "shareRootView", "Landroid/widget/ImageView;", "R0", "Landroid/widget/ImageView;", "resultIgv", "<init>", "(Landroid/content/Context;Lzd3/a;ILjava/lang/String;)V", "S0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ak extends ShareActionSheetV2 implements h {

    /* renamed from: J0, reason: from kotlin metadata */
    private g presenter;

    /* renamed from: K0, reason: from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: L0, reason: from kotlin metadata */
    private final int gender;

    /* renamed from: M0, reason: from kotlin metadata */
    private final String source;

    /* renamed from: N0, reason: from kotlin metadata */
    private LinearLayout actionSheetLayout;

    /* renamed from: O0, reason: from kotlin metadata */
    private WeakReference<Activity> mWeakActivity;

    /* renamed from: P0, reason: from kotlin metadata */
    private ViewGroup mSharePictureLayout;

    /* renamed from: Q0, reason: from kotlin metadata */
    private View shareRootView;

    /* renamed from: R0, reason: from kotlin metadata */
    private ImageView resultIgv;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ak(Context context, zd3.a aVar, int i3, String source) {
        super(r0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        this.dtReporter = aVar;
        this.gender = i3;
        this.source = source;
        this.mWeakActivity = new WeakReference<>(v0(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        java.lang.ref.WeakReference<Context> weakReference = this$0.f317430e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this$0.w0().startAnimation(AnimationUtils.loadAnimation(this$0.f317430e.get(), R.anim.f154349j6));
        LinearLayout linearLayout = this$0.actionSheetLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionSheetLayout");
            linearLayout = null;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, linearLayout.getHeight(), 0.0f);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setStartTime(300L);
        translateAnimation.setDuration(300L);
        LinearLayout linearLayout3 = this$0.actionSheetLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionSheetLayout");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ak this$0, View view) {
        zd3.a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_clck_type", "close");
        linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
        ImageView cancel = this$0.P;
        if (cancel != null && (aVar = this$0.dtReporter) != null) {
            Intrinsics.checkNotNullExpressionValue(cancel, "cancel");
            aVar.t(cancel, "em_zplan_share_panel", linkedHashMap);
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ak this$0, View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Intrinsics.checkNotNullExpressionValue(item, "item");
        Intrinsics.checkNotNullExpressionValue(shareActionSheet, "shareActionSheet");
        this$0.x0(view, item, shareActionSheet);
    }

    private final Activity v0(Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return v0(((ContextWrapper) context).getBaseContext());
    }

    private final void x0(View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Activity activity = this.mWeakActivity.get();
        if (activity == null) {
            QLog.e("SuitShareActionSheet", 1, "handleItemClick Error, mActivity == null");
            return;
        }
        int i3 = item.action;
        g gVar = null;
        if (i3 == 2) {
            QLog.d("SuitShareActionSheet", 1, "ACTION_SEND_TO_FRIEND");
            g gVar2 = this.presenter;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                gVar = gVar2;
            }
            gVar.c(activity);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clck_type", "qq");
            linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
            zd3.a aVar = this.dtReporter;
            if (aVar != null) {
                aVar.t(view, "em_zplan_share_panel", linkedHashMap);
            }
        } else if (i3 == 3) {
            QLog.d("SuitShareActionSheet", 1, "ACTION_SEND_TO_QZONE");
            g gVar3 = this.presenter;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                gVar = gVar3;
            }
            gVar.b(activity);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("zplan_clck_type", "zone");
            linkedHashMap2.put("dt_pgid", "pg_zplan_create_new");
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 != null) {
                aVar2.t(view, "em_zplan_share_panel", linkedHashMap2);
            }
        } else if (i3 == 9) {
            QLog.d("SuitShareActionSheet", 1, "ACTION_SEND_TO_WECHAT");
            g gVar4 = this.presenter;
            if (gVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                gVar = gVar4;
            }
            gVar.d(activity, item.action);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("dt_pgid", "pg_zplan_create_new");
            linkedHashMap3.put("zplan_clck_type", "wechat");
            zd3.a aVar3 = this.dtReporter;
            if (aVar3 != null) {
                aVar3.t(view, "em_zplan_share_panel", linkedHashMap3);
            }
        } else if (i3 == 39) {
            QLog.d("SuitShareActionSheet", 1, "ACTION_SAVE");
            g gVar5 = this.presenter;
            if (gVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                gVar = gVar5;
            }
            gVar.f(activity);
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put("zplan_clck_type", "save");
            linkedHashMap4.put("dt_pgid", "pg_zplan_create_new");
            zd3.a aVar4 = this.dtReporter;
            if (aVar4 != null) {
                aVar4.t(view, "em_zplan_share_panel", linkedHashMap4);
            }
        } else if (i3 == 203) {
            QLog.d("SuitShareActionSheet", 1, "ACTION_SHARE_TO_LITTLE_WORLD");
            g gVar6 = this.presenter;
            if (gVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                gVar = gVar6;
            }
            gVar.g(activity);
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            linkedHashMap5.put("zplan_clck_type", "xsj");
            linkedHashMap5.put("dt_pgid", "pg_zplan_create_new");
            zd3.a aVar5 = this.dtReporter;
            if (aVar5 != null) {
                aVar5.t(view, "em_zplan_share_panel", linkedHashMap5);
            }
        } else if (i3 == 218) {
            QLog.d("SuitShareActionSheet", 1, "ACTION_SEND_TO_XHS");
            g gVar7 = this.presenter;
            if (gVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                gVar = gVar7;
            }
            gVar.a(activity);
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            linkedHashMap6.put("dt_pgid", "pg_zplan_create_new");
            linkedHashMap6.put("zplan_clck_type", "red_book");
            zd3.a aVar6 = this.dtReporter;
            if (aVar6 != null) {
                aVar6.t(view, "em_zplan_share_panel", linkedHashMap6);
            }
        }
        dismiss();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    protected int I() {
        return R.layout.dft;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.h
    public void a(Bitmap bitmap) {
        ImageView imageView = this.resultIgv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultIgv");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
    public void show() {
        super.show();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ah
            @Override // java.lang.Runnable
            public final void run() {
                ak.A0(ak.this);
            }
        });
    }

    public final void u0(c genPosterCallback) {
        Intrinsics.checkNotNullParameter(genPosterCallback, "genPosterCallback");
        g gVar = this.presenter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            gVar = null;
        }
        SuitShareData data = gVar.getData();
        com.tencent.mobileqq.zplan.aigc.share.b.f330597a.e("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_share_word_new_3.png", "aigc_suit_share_word_new_3.png", "suit_cache_dir", new b(new Ref.ObjectRef(), new Ref.ObjectRef(), this, data, data.getClothBitmap(), genPosterCallback));
    }

    public final ViewGroup w0() {
        ViewGroup viewGroup = this.mSharePictureLayout;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSharePictureLayout");
        return null;
    }

    public final void y0(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.W = items;
        this.f317425a0 = true;
    }

    public void z0(g presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    public View C() {
        QLog.i("SuitShareActionSheet", 1, "createViewFlipper");
        View C = super.C();
        Intrinsics.checkNotNullExpressionValue(C, "super.createViewFlipper()");
        View findViewById = C.findViewById(R.id.f163524ql2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.share_picture_container)");
        this.mSharePictureLayout = (ViewGroup) findViewById;
        View view = null;
        View inflate = View.inflate(this.f317430e.get(), R.layout.dfu, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(mContextWeakRef.\u2026are_picture_layout, null)");
        this.shareRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRootView");
            inflate = null;
        }
        View findViewById2 = inflate.findViewById(R.id.qhe);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "shareRootView.findViewById(R.id.result)");
        this.resultIgv = (ImageView) findViewById2;
        ViewGroup w06 = w0();
        View view2 = this.shareRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRootView");
        } else {
            view = view2;
        }
        w06.addView(view);
        View findViewById3 = C.findViewById(R.id.p9v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.action_sheet_layout)");
        this.actionSheetLayout = (LinearLayout) findViewById3;
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.share.ai
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ak.s0(ak.this, view3);
                }
            });
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.source);
        linkedHashMap.put("zplan_gender", Integer.valueOf(this.gender));
        zd3.a aVar = this.dtReporter;
        if (aVar != null) {
            aVar.c(this, C, "pg_zplan_create_new", linkedHashMap);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("dt_pgid", "pg_zplan_create_new");
        zd3.a aVar2 = this.dtReporter;
        if (aVar2 != null) {
            zd3.a.y(aVar2, w0(), "em_zplan_share_panel", linkedHashMap2, null, 8, null);
        }
        setItemClickListenerV3(new ShareActionSheet.c() { // from class: com.tencent.mobileqq.zplan.aigc.share.aj
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
            public final void w6(View view3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                ak.t0(ak.this, view3, actionSheetItem, shareActionSheet);
            }
        });
        return C;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/share/ak$b", "Lcom/tencent/mobileqq/zplan/aigc/share/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "error", "onFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Bitmap> f330552a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Bitmap> f330553b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ak f330554c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SuitShareData f330555d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bitmap f330556e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f330557f;

        b(Ref.ObjectRef<Bitmap> objectRef, Ref.ObjectRef<Bitmap> objectRef2, ak akVar, SuitShareData suitShareData, Bitmap bitmap, c cVar) {
            this.f330552a = objectRef;
            this.f330553b = objectRef2;
            this.f330554c = akVar;
            this.f330555d = suitShareData;
            this.f330556e = bitmap;
            this.f330557f = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(c genPosterCallback, String error) {
            Intrinsics.checkNotNullParameter(genPosterCallback, "$genPosterCallback");
            Intrinsics.checkNotNullParameter(error, "$error");
            genPosterCallback.onFailure(error);
            QLog.e("SuitShareActionSheet", 1, "download word bitmap failed");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void d(Ref.ObjectRef wordBitmap, Bitmap bitmap, Ref.ObjectRef maskBitmap, ak this$0, SuitShareData suitShareData, Bitmap bitmap2, c genPosterCallback) {
            Intrinsics.checkNotNullParameter(wordBitmap, "$wordBitmap");
            Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
            Intrinsics.checkNotNullParameter(maskBitmap, "$maskBitmap");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(suitShareData, "$suitShareData");
            Intrinsics.checkNotNullParameter(genPosterCallback, "$genPosterCallback");
            wordBitmap.element = bitmap;
            com.tencent.mobileqq.zplan.aigc.share.b.f330597a.e("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_share_avatar_mask_3.png", "aigc_suit_share_avatar_mask_3.png", "suit_cache_dir", new a(maskBitmap, this$0, suitShareData, wordBitmap, bitmap2, genPosterCallback));
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.d
        public void onFailure(final String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final c cVar = this.f330557f;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.al
                @Override // java.lang.Runnable
                public final void run() {
                    ak.b.c(c.this, error);
                }
            });
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.d
        public void onSuccess(final Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Ref.ObjectRef<Bitmap> objectRef = this.f330552a;
            final Ref.ObjectRef<Bitmap> objectRef2 = this.f330553b;
            final ak akVar = this.f330554c;
            final SuitShareData suitShareData = this.f330555d;
            final Bitmap bitmap2 = this.f330556e;
            final c cVar = this.f330557f;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.am
                @Override // java.lang.Runnable
                public final void run() {
                    ak.b.d(Ref.ObjectRef.this, bitmap, objectRef2, akVar, suitShareData, bitmap2, cVar);
                }
            });
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/share/ak$b$a", "Lcom/tencent/mobileqq/zplan/aigc/share/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "error", "onFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Bitmap> f330558a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ak f330559b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ SuitShareData f330560c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Bitmap> f330561d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bitmap f330562e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f330563f;

            a(Ref.ObjectRef<Bitmap> objectRef, ak akVar, SuitShareData suitShareData, Ref.ObjectRef<Bitmap> objectRef2, Bitmap bitmap, c cVar) {
                this.f330558a = objectRef;
                this.f330559b = akVar;
                this.f330560c = suitShareData;
                this.f330561d = objectRef2;
                this.f330562e = bitmap;
                this.f330563f = cVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(c genPosterCallback, String error) {
                Intrinsics.checkNotNullParameter(genPosterCallback, "$genPosterCallback");
                Intrinsics.checkNotNullParameter(error, "$error");
                genPosterCallback.onFailure(error);
                QLog.e("SuitShareActionSheet", 1, "download mask failed");
            }

            @Override // com.tencent.mobileqq.zplan.aigc.share.d
            public void onFailure(final String error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final c cVar = this.f330563f;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.an
                    @Override // java.lang.Runnable
                    public final void run() {
                        ak.b.a.c(c.this, error);
                    }
                });
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mobileqq.zplan.aigc.share.d
            public void onSuccess(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.f330558a.element = bitmap;
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final ak akVar = this.f330559b;
                final SuitShareData suitShareData = this.f330560c;
                final Ref.ObjectRef<Bitmap> objectRef = this.f330561d;
                final Ref.ObjectRef<Bitmap> objectRef2 = this.f330558a;
                final Bitmap bitmap2 = this.f330562e;
                final c cVar = this.f330563f;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ao
                    @Override // java.lang.Runnable
                    public final void run() {
                        ak.b.a.d(ak.this, suitShareData, objectRef, objectRef2, bitmap2, cVar);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public static final void d(ak this$0, SuitShareData suitShareData, Ref.ObjectRef wordBitmap, Ref.ObjectRef maskBitmap, Bitmap bitmap, c genPosterCallback) {
                g gVar;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(suitShareData, "$suitShareData");
                Intrinsics.checkNotNullParameter(wordBitmap, "$wordBitmap");
                Intrinsics.checkNotNullParameter(maskBitmap, "$maskBitmap");
                Intrinsics.checkNotNullParameter(genPosterCallback, "$genPosterCallback");
                g gVar2 = this$0.presenter;
                g gVar3 = null;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    gVar = null;
                } else {
                    gVar = gVar2;
                }
                Bitmap h16 = gVar.h(suitShareData.getUgcId(), suitShareData.getBgBitmap(), (Bitmap) wordBitmap.element, suitShareData.getAvatarBitmap(), (Bitmap) maskBitmap.element, bitmap);
                g gVar4 = this$0.presenter;
                if (gVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                } else {
                    gVar3 = gVar4;
                }
                gVar3.e(h16);
                genPosterCallback.onSuccess(h16);
            }
        }
    }
}
