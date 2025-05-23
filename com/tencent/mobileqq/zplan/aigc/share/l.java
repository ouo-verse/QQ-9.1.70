package com.tencent.mobileqq.zplan.aigc.share;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
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
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001\u0016B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$\u0012\u0006\u0010,\u001a\u00020%\u0012\b\u00100\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\bJ\u0010KJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J+\u0010\u001d\u001a\u00020\r2\u001c\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u001aj\b\u0012\u0004\u0012\u00020\t`\u001b0\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0007H\u0014J\b\u0010 \u001a\u00020\rH\u0016J\u000e\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/l;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "Lcom/tencent/mobileqq/zplan/aigc/share/f;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "u0", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "w0", "", "I", "Lcom/tencent/mobileqq/zplan/aigc/share/e;", "presenter", "z0", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "a", "", "isShowing", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "items", "x0", "([Ljava/util/ArrayList;)V", BdhLogUtil.LogTag.Tag_Conn, "show", "Lcom/tencent/mobileqq/zplan/aigc/share/c;", "genPosterCallback", "t0", "", "", "", "J0", "Ljava/util/Map;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "K0", "Ljava/lang/String;", "pageId", "Lzd3/a;", "L0", "Lzd3/a;", "dtReporter", "M0", "Lcom/tencent/mobileqq/zplan/aigc/share/e;", "Landroid/widget/LinearLayout;", "N0", "Landroid/widget/LinearLayout;", "actionSheetLayout", "Lmqq/util/WeakReference;", "O0", "Lmqq/util/WeakReference;", "mWeakActivity", "Landroid/view/ViewGroup;", "P0", "Landroid/view/ViewGroup;", "v0", "()Landroid/view/ViewGroup;", "y0", "(Landroid/view/ViewGroup;)V", "mSharePictureLayout", "Q0", "Landroid/view/View;", "shareRootView", "Landroid/widget/ImageView;", "R0", "Landroid/widget/ImageView;", "resultIgv", "<init>", "(Landroid/content/Context;Ljava/util/Map;Ljava/lang/String;Lzd3/a;)V", "S0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l extends ShareActionSheetV2 implements f {

    /* renamed from: J0, reason: from kotlin metadata */
    private final Map<String, Object> pageParams;

    /* renamed from: K0, reason: from kotlin metadata */
    private final String pageId;

    /* renamed from: L0, reason: from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: M0, reason: from kotlin metadata */
    private e presenter;

    /* renamed from: N0, reason: from kotlin metadata */
    private LinearLayout actionSheetLayout;

    /* renamed from: O0, reason: from kotlin metadata */
    private WeakReference<Activity> mWeakActivity;

    /* renamed from: P0, reason: from kotlin metadata */
    public ViewGroup mSharePictureLayout;

    /* renamed from: Q0, reason: from kotlin metadata */
    private View shareRootView;

    /* renamed from: R0, reason: from kotlin metadata */
    private ImageView resultIgv;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l(Context context, Map<String, Object> pageParams, String pageId, zd3.a aVar) {
        super(r0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        this.pageParams = pageParams;
        this.pageId = pageId;
        this.dtReporter = aVar;
        this.mWeakActivity = new WeakReference<>(u0(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        java.lang.ref.WeakReference<Context> weakReference = this$0.f317430e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this$0.v0().startAnimation(AnimationUtils.loadAnimation(this$0.f317430e.get(), R.anim.f154349j6));
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
    public static final void r0(l this$0, View view) {
        zd3.a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_clck_type", "close");
        linkedHashMap.put("dt_pgid", this$0.pageId);
        ImageView cancel = this$0.P;
        if (cancel != null && (aVar = this$0.dtReporter) != null) {
            Intrinsics.checkNotNullExpressionValue(cancel, "cancel");
            aVar.t(cancel, "em_zplan_share_panel", linkedHashMap);
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(l this$0, View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Intrinsics.checkNotNullExpressionValue(item, "item");
        Intrinsics.checkNotNullExpressionValue(shareActionSheet, "shareActionSheet");
        this$0.w0(view, item, shareActionSheet);
    }

    private final Activity u0(Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return u0(((ContextWrapper) context).getBaseContext());
    }

    private final void w0(View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Activity activity = this.mWeakActivity.get();
        if (activity == null) {
            QLog.e("SuitOutfitShareActionSheet", 1, "handleItemClick Error, mActivity == null");
            return;
        }
        int i3 = item.action;
        e eVar = null;
        if (i3 == 2) {
            QLog.d("SuitOutfitShareActionSheet", 1, "ACTION_SEND_TO_FRIEND");
            e eVar2 = this.presenter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                eVar = eVar2;
            }
            eVar.c(activity);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clck_type", "qq");
            linkedHashMap.put("dt_pgid", this.pageId);
            zd3.a aVar = this.dtReporter;
            if (aVar != null) {
                aVar.t(view, "em_zplan_share_panel", linkedHashMap);
            }
        } else if (i3 == 3) {
            QLog.d("SuitOutfitShareActionSheet", 1, "ACTION_SEND_TO_QZONE");
            e eVar3 = this.presenter;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                eVar = eVar3;
            }
            eVar.b(activity);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("zplan_clck_type", "zone");
            linkedHashMap2.put("dt_pgid", this.pageId);
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 != null) {
                aVar2.t(view, "em_zplan_share_panel", linkedHashMap2);
            }
        } else if (i3 == 9) {
            QLog.d("SuitOutfitShareActionSheet", 1, "ACTION_SEND_TO_WECHAT");
            e eVar4 = this.presenter;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                eVar = eVar4;
            }
            eVar.d(activity, item.action);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("dt_pgid", this.pageId);
            linkedHashMap3.put("zplan_clck_type", "wechat");
            zd3.a aVar3 = this.dtReporter;
            if (aVar3 != null) {
                aVar3.t(view, "em_zplan_share_panel", linkedHashMap3);
            }
        } else if (i3 == 39) {
            QLog.d("SuitOutfitShareActionSheet", 1, "ACTION_SAVE");
            e eVar5 = this.presenter;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                eVar = eVar5;
            }
            eVar.f(activity);
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put("zplan_clck_type", "save");
            linkedHashMap4.put("dt_pgid", this.pageId);
            zd3.a aVar4 = this.dtReporter;
            if (aVar4 != null) {
                aVar4.t(view, "em_zplan_share_panel", linkedHashMap4);
            }
        } else if (i3 == 203) {
            QLog.d("SuitOutfitShareActionSheet", 1, "ACTION_SHARE_TO_LITTLE_WORLD");
            e eVar6 = this.presenter;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                eVar = eVar6;
            }
            eVar.g(activity);
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            linkedHashMap5.put("zplan_clck_type", "xsj");
            linkedHashMap5.put("dt_pgid", this.pageId);
            zd3.a aVar5 = this.dtReporter;
            if (aVar5 != null) {
                aVar5.t(view, "em_zplan_share_panel", linkedHashMap5);
            }
        } else if (i3 == 218) {
            QLog.d("SuitOutfitShareActionSheet", 1, "ACTION_SEND_TO_XHS");
            e eVar7 = this.presenter;
            if (eVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            } else {
                eVar = eVar7;
            }
            eVar.a(activity);
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            linkedHashMap6.put("dt_pgid", this.pageId);
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
        return R.layout.dfr;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.f
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
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.i
            @Override // java.lang.Runnable
            public final void run() {
                l.A0(l.this);
            }
        });
    }

    public final void t0(c genPosterCallback) {
        e eVar;
        Intrinsics.checkNotNullParameter(genPosterCallback, "genPosterCallback");
        e eVar2 = this.presenter;
        e eVar3 = null;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            eVar2 = null;
        }
        SuitOutfitShareData data = eVar2.getData();
        e eVar4 = this.presenter;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            eVar = null;
        } else {
            eVar = eVar4;
        }
        Bitmap h16 = eVar.h(data.getBackgroundBitmap(), data.getMaskBitmap(), data.getAvatarBitmap(), data.h(), data.g(), data.getGoodLookBubbleBitmap(), data.getVeryGoodLookBubbleBitmap(), data.getCreateTs(), data.getNickName());
        e eVar5 = this.presenter;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        } else {
            eVar3 = eVar5;
        }
        eVar3.e(h16);
        genPosterCallback.onSuccess(h16);
    }

    public final ViewGroup v0() {
        ViewGroup viewGroup = this.mSharePictureLayout;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSharePictureLayout");
        return null;
    }

    public final void x0(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.W = items;
        this.f317425a0 = true;
    }

    public final void y0(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mSharePictureLayout = viewGroup;
    }

    public void z0(e presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    public View C() {
        QLog.i("SuitOutfitShareActionSheet", 1, "createViewFlipper");
        View C = super.C();
        Intrinsics.checkNotNullExpressionValue(C, "super.createViewFlipper()");
        View findViewById = C.findViewById(R.id.f163524ql2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.share_picture_container)");
        y0((ViewGroup) findViewById);
        View view = null;
        View inflate = View.inflate(this.f317430e.get(), R.layout.dfs, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(mContextWeakRef.\u2026are_picture_layout, null)");
        this.shareRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRootView");
            inflate = null;
        }
        View findViewById2 = inflate.findViewById(R.id.qhe);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "shareRootView.findViewById(R.id.result)");
        this.resultIgv = (ImageView) findViewById2;
        ViewGroup v06 = v0();
        View view2 = this.shareRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRootView");
        } else {
            view = view2;
        }
        v06.addView(view);
        View findViewById3 = C.findViewById(R.id.p9v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.action_sheet_layout)");
        this.actionSheetLayout = (LinearLayout) findViewById3;
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.share.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    l.r0(l.this, view3);
                }
            });
        }
        zd3.a aVar = this.dtReporter;
        if (aVar != null) {
            aVar.c(this, C, this.pageId, this.pageParams);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", this.pageId);
        zd3.a aVar2 = this.dtReporter;
        if (aVar2 != null) {
            zd3.a.y(aVar2, v0(), "em_zplan_share_panel", linkedHashMap, null, 8, null);
        }
        setItemClickListenerV3(new ShareActionSheet.c() { // from class: com.tencent.mobileqq.zplan.aigc.share.k
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
            public final void w6(View view3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                l.s0(l.this, view3, actionSheetItem, shareActionSheet);
            }
        });
        return C;
    }
}
