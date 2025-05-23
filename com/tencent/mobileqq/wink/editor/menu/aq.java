package com.tencent.mobileqq.wink.editor.menu;

import a63.WinkBubbleInfo;
import a63.a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart;
import com.tencent.mobileqq.wink.editor.view.NonScrollableScrollView;
import com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J&\u0010\u0011\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0014J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u001f\u001a\u00020\u0002H\u0014J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0014J\u0012\u0010#\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\u001c\u0010&\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u00102\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0015H\u0016R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0014\u00107\u001a\u0002048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u0002048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010=\u001a\u00020:8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010GR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/menu/aq;", "Lcom/tencent/mobileqq/wink/editor/menu/u;", "", "initViewModel", "Wb", "", "Lcom/tencent/mobileqq/wink/editor/menu/MenuItem;", "menuItems", "", "expandHeight", "collapsedHeight", "Xb", "Zb", "newMenuSize", "Gb", "i", "Landroid/view/View;", "Eb", "", "getLogTag", "B9", "", "isPartEnable", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "z9", "items", "ua", "sa", "ab", "La63/b;", "bubbleInfo", "cb", "Qa", "child", HippyNestedScrollComponent.PRIORITY_PARENT, "va", "isHDROn", "fb", "P", "I", "padding", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "menuHeight", BdhLogUtil.LogTag.Tag_Req, "gapHeight", ExifInterface.LATITUDE_SOUTH, "iconWidth", "T", "foldIconGapHeight", "", "U", UserInfo.SEX_FEMALE, "bgFoldAlpha", "V", "bgUnFoldAlpha", "", "W", "J", "animatorDuration", "Landroidx/constraintlayout/widget/ConstraintLayout;", "X", "Landroidx/constraintlayout/widget/ConstraintLayout;", "parentLayout", "Lcom/tencent/mobileqq/wink/editor/view/NonScrollableScrollView;", "Y", "Lcom/tencent/mobileqq/wink/editor/view/NonScrollableScrollView;", "menuScrollView", "Landroid/widget/ImageView;", "Z", "Landroid/widget/ImageView;", "arrowImageView", "a0", "bgImageView", "b0", "expand", "c0", "Ljava/util/List;", "currentMenuItem", "<init>", "()V", "d0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class aq extends u {

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout parentLayout;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private NonScrollableScrollView menuScrollView;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private ImageView arrowImageView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView bgImageView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean expand;

    /* renamed from: P, reason: from kotlin metadata */
    private int padding = e83.a.d(6);

    /* renamed from: Q, reason: from kotlin metadata */
    private int menuHeight = e83.a.d(48);

    /* renamed from: R, reason: from kotlin metadata */
    private int gapHeight = e83.a.d(17);

    /* renamed from: S, reason: from kotlin metadata */
    private int iconWidth = e83.a.d(24);

    /* renamed from: T, reason: from kotlin metadata */
    private int foldIconGapHeight = e83.a.d(12);

    /* renamed from: U, reason: from kotlin metadata */
    private final float bgFoldAlpha = 0.4f;

    /* renamed from: V, reason: from kotlin metadata */
    private final float bgUnFoldAlpha = 1.0f;

    /* renamed from: W, reason: from kotlin metadata */
    private final long animatorDuration = 500;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends MenuItem> currentMenuItem = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/menu/aq$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f320544d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ aq f320545e;

        b(ImageView imageView, aq aqVar) {
            this.f320544d = imageView;
            this.f320545e = aqVar;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            Bitmap bitmap;
            super.onStateChange(state, option);
            if (state == LoadState.STATE_SUCCESS) {
                ImageView imageView = this.f320544d;
                if (option != null) {
                    bitmap = option.getResultBitMap();
                } else {
                    bitmap = null;
                }
                imageView.setImageBitmap(bitmap);
                return;
            }
            w53.b.g(this.f320545e.getTAG(), "state:" + state);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/menu/aq$c", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            Bitmap bitmap;
            super.onStateChange(state, option);
            if (state == LoadState.STATE_SUCCESS) {
                w53.b.a(aq.this.getTAG(), "bgImageView set alpha");
                ImageView imageView = aq.this.bgImageView;
                if (imageView != null) {
                    imageView.setAlpha(aq.this.bgFoldAlpha);
                }
                ImageView imageView2 = aq.this.bgImageView;
                if (imageView2 != null) {
                    if (option != null) {
                        bitmap = option.getResultBitMap();
                    } else {
                        bitmap = null;
                    }
                    imageView2.setImageBitmap(bitmap);
                    return;
                }
                return;
            }
            w53.b.g(aq.this.getTAG(), "state:" + state);
        }
    }

    private final View Eb(List<? extends MenuItem> menuItems, int i3, int newMenuSize) {
        int d16;
        final MenuItem menuItem = menuItems.get(i3);
        View menuItemView = LayoutInflater.from(getContext()).inflate(R.layout.hcu, (ViewGroup) this.D, false);
        TextView textView = (TextView) menuItemView.findViewById(R.id.z3f);
        textView.setText(menuItem.getTitle());
        textView.setTag(menuItem.getMenuType());
        textView.setCompoundDrawablesWithIntrinsicBounds(0, menuItem.getIcon(), 0, 0);
        ta(menuItem, menuItemView, textView);
        menuItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aq.Fb(aq.this, menuItem, view);
            }
        });
        if (i3 != newMenuSize - 1) {
            d16 = this.gapHeight;
        } else {
            d16 = e83.a.d(0);
        }
        LinearLayout linearLayout = this.D;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = d16;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(menuItemView, layoutParams);
        HashMap<MenuItem, View> menuItemViewMap = this.H;
        Intrinsics.checkNotNullExpressionValue(menuItemViewMap, "menuItemViewMap");
        menuItemViewMap.put(menuItem, menuItemView);
        Intrinsics.checkNotNullExpressionValue(menuItemView, "menuItemView");
        return menuItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fb(aq this$0, MenuItem menuItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
        this$0.G9().F4(menuItem.getMenuType());
        this$0.eb(menuItem.getMenuType());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Gb(int newMenuSize, List<? extends MenuItem> menuItems) {
        for (int i3 = 0; i3 < newMenuSize; i3++) {
            Eb(menuItems, i3, newMenuSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hb(aq this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.expand = !this$0.expand;
        this$0.G9().I4();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ib(aq this$0, MenuType menuType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuType, "menuType");
        w53.b.a(this$0.getTAG(), "getMenuRedDotLiveData = " + menuType);
        this$0.la(menuType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jb(aq this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pair, "pair");
        w53.b.a(this$0.getTAG(), "getNotifyTypeChildClear = " + pair);
        MenuType menuType = (MenuType) pair.getFirst();
        if (MenuType.VIDEO_TEMPLATE == menuType) {
            this$0.la(menuType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kb(aq this$0, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ConstraintLayout constraintLayout = this$0.parentLayout;
        if (constraintLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            constraintLayout.setVisibility(i3);
        }
        if (z16 && this$0.G9().a2()) {
            MenuType menuType = MenuType.VIDEO_FIRST_TEMPLATE;
            if (this$0.ra(menuType) != null) {
                com.tencent.mobileqq.wink.editor.template.c cVar = com.tencent.mobileqq.wink.editor.template.c.f322362a;
                View ra5 = this$0.ra(menuType);
                Intrinsics.checkNotNullExpressionValue(ra5, "getMenuView(MenuType.VIDEO_FIRST_TEMPLATE)");
                cVar.b(ra5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lb(aq this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.G9().getIsFromTemplateColl()) {
            this$0.gb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mb(aq this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.G9().getIsFromTemplateColl() && this$0.G9().a2()) {
            this$0.gb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nb(aq this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ob(aq this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null && z16 && (H9 instanceof WinkVideoTavCut)) {
            ((WinkVideoTavCut) H9).n2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pb(aq this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ua(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qb(aq this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a63.a a16 = a63.a.INSTANCE.a();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNull(str);
        this$0.Qa(a16.e(context, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rb(aq this$0, String str) {
        WinkBubbleInfo winkBubbleInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            a63.a a16 = a63.a.INSTANCE.a();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            winkBubbleInfo = a16.e(context, str);
        } else {
            winkBubbleInfo = null;
        }
        this$0.Qa(winkBubbleInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sb(aq this$0, MenuType menuType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.eb(menuType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tb(aq this$0, MenuSwitchAction menuSwitchAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vb(aq this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NonScrollableScrollView nonScrollableScrollView = this$0.menuScrollView;
        if (nonScrollableScrollView != null) {
            nonScrollableScrollView.smoothScrollTo(0, 0);
        }
    }

    private final void Wb() {
        this.padding = e83.a.d(6);
        this.menuHeight = e83.a.d(48);
        this.gapHeight = e83.a.d(17);
        this.iconWidth = e83.a.d(24);
        this.foldIconGapHeight = e83.a.d(12);
    }

    private final void Xb(List<? extends MenuItem> menuItems, int expandHeight, int collapsedHeight) {
        Integer num;
        int i3;
        ValueAnimator ofInt;
        ViewGroup.LayoutParams layoutParams;
        this.D.setPadding(0, this.padding, 0, 0);
        if (this.D.getChildCount() == 0) {
            Gb(menuItems.size(), menuItems);
            ConstraintLayout constraintLayout = this.parentLayout;
            if (constraintLayout != null) {
                ViewGroup.LayoutParams layoutParams2 = constraintLayout.getLayoutParams();
                if (!this.expand) {
                    expandHeight = collapsedHeight;
                }
                layoutParams2.height = expandHeight;
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout2 = this.parentLayout;
        if (constraintLayout2 != null && (layoutParams = constraintLayout2.getLayoutParams()) != null) {
            num = Integer.valueOf(layoutParams.height);
        } else {
            num = null;
        }
        if (this.expand) {
            i3 = expandHeight;
        } else {
            i3 = collapsedHeight;
        }
        if (num != null && num.intValue() == i3) {
            return;
        }
        if (this.expand) {
            ofInt = ValueAnimator.ofInt(collapsedHeight, expandHeight);
        } else {
            ofInt = ValueAnimator.ofInt(expandHeight, collapsedHeight);
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.menu.af
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aq.Yb(aq.this, valueAnimator);
            }
        });
        if (!this.expand) {
            ofInt.addListener(new d());
        }
        ofInt.setDuration(this.animatorDuration);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yb(aq this$0, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ConstraintLayout constraintLayout = this$0.parentLayout;
        if (constraintLayout != null) {
            layoutParams = constraintLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.height = intValue;
        }
        ConstraintLayout constraintLayout2 = this$0.parentLayout;
        if (constraintLayout2 != null) {
            constraintLayout2.requestLayout();
        }
    }

    private final void Zb(int expandHeight, int collapsedHeight) {
        float f16;
        boolean z16;
        float f17;
        int d16;
        int d17;
        int width;
        int d18;
        int d19;
        final ImageView imageView = this.bgImageView;
        if (imageView != null) {
            if (this.expand) {
                f16 = this.bgUnFoldAlpha;
            } else {
                f16 = this.bgFoldAlpha;
            }
            if (imageView.getAlpha() == f16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            if (this.expand) {
                f17 = this.bgFoldAlpha;
            } else {
                f17 = this.bgUnFoldAlpha;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, f17, f16);
            if (this.expand) {
                d16 = (e83.a.d(48) * 2) + expandHeight;
            } else {
                d16 = (e83.a.d(40) * 2) + collapsedHeight;
            }
            if (this.expand) {
                d17 = collapsedHeight + (e83.a.d(40) * 2);
            } else {
                d17 = (e83.a.d(48) * 2) + expandHeight;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(d17, d16);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.menu.ad
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    aq.ac(imageView, valueAnimator);
                }
            });
            if (this.expand) {
                width = this.D.getWidth();
                d18 = e83.a.d(57);
            } else {
                width = this.D.getWidth();
                d18 = e83.a.d(35);
            }
            int i3 = width + d18;
            if (this.expand) {
                d19 = this.D.getWidth() + e83.a.d(35);
            } else {
                d19 = e83.a.d(57) + this.D.getWidth();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(d19, i3);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.menu.ae
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    aq.bc(imageView, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofInt, ofInt2);
            animatorSet.setDuration(this.animatorDuration);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ac(ImageView this_apply, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ViewGroup.LayoutParams layoutParams = this_apply.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this_apply.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bc(ImageView this_apply, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ViewGroup.LayoutParams layoutParams = this_apply.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.width = ((Integer) animatedValue).intValue();
        this_apply.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cc(com.tencent.mobileqq.widget.tip.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        aVar.o();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initViewModel() {
        this.E = (WinkEditorViewModel) getViewModel(WinkEditorViewModel.class);
        this.G = (com.tencent.mobileqq.wink.editor.template.x) getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
        this.F = (com.tencent.mobileqq.wink.editor.hdr.q) getViewModel(com.tencent.mobileqq.wink.editor.hdr.q.class);
        G9().o2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Pb(aq.this, (List) obj);
            }
        });
        G9().a3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Qb(aq.this, (String) obj);
            }
        });
        G9().l3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Rb(aq.this, (String) obj);
            }
        });
        G9().p2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Sb(aq.this, (MenuType) obj);
            }
        });
        G9().f3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Tb(aq.this, (MenuSwitchAction) obj);
            }
        });
        G9().d3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Ib(aq.this, (MenuType) obj);
            }
        });
        WinkMaterialRedDotManager.f326249a.b().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Jb(aq.this, (Pair) obj);
            }
        });
        G9().q2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Kb(aq.this, ((Boolean) obj).booleanValue());
            }
        });
        G9().n3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Lb(aq.this, (List) obj);
            }
        });
        this.G.R1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Mb(aq.this, (Boolean) obj);
            }
        });
        this.F.S1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Nb(aq.this, obj);
            }
        });
        this.F.Q1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aq.Ob(aq.this, ((Boolean) obj).booleanValue());
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u, com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.t9l;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u
    protected void Qa(@Nullable WinkBubbleInfo bubbleInfo) {
        MenuItem b16 = a63.a.INSTANCE.b(bubbleInfo);
        if (b16 != null && qa(b16) != null) {
            if (DailyNextBtnPart.INSTANCE.e()) {
                w53.b.f(getTAG(), "onMenuExposure... need to show daily bubble");
                return;
            }
            Intrinsics.checkNotNull(bubbleInfo);
            if (bubbleInfo.getShowLevel() == 3) {
                G9().r5();
            }
            if (qa(b16).getMeasuredWidth() <= 0) {
                Ra(bubbleInfo);
            } else if (!va(qa(b16), this.parentLayout)) {
                Sa(bubbleInfo);
            } else {
                cb(bubbleInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u
    protected void ab() {
        int i3;
        Integer num;
        if (G9().getCurMenuType() == MenuType.BOTTOM_DASHBOARD && H9() != null) {
            dr H9 = H9();
            Intrinsics.checkNotNull(H9);
            if (!H9.p() && (H9() instanceof WinkVideoTavCut) && !G9().getIsHDRExporting() && !this.F.getHdrIniting() && !this.F.getCom.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String()) {
                dr H92 = H9();
                Intrinsics.checkNotNull(H92);
                if (!H92.G()) {
                    WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils = WinkHDRPicQualityDetectUtils.f320445a;
                    WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) H9();
                    Intrinsics.checkNotNull(winkVideoTavCut);
                    if (winkHDRPicQualityDetectUtils.p(winkVideoTavCut.a0()) && !G9().getIsAllImages()) {
                        WinkVideoTavCut winkVideoTavCut2 = (WinkVideoTavCut) H9();
                        Intrinsics.checkNotNull(winkVideoTavCut2);
                        if (!winkHDRPicQualityDetectUtils.l(winkVideoTavCut2.a0())) {
                            return;
                        }
                        a.Companion companion = a63.a.INSTANCE;
                        a63.a a16 = companion.a();
                        Activity activity = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        WinkBubbleInfo e16 = a16.e(activity, "winkEnhanceTip");
                        View ra5 = ra(MenuType.ENHANCE);
                        if (getActivity() != null && !getActivity().isFinishing() && e16 != null && ra5 != null && this.parentLayout != null) {
                            if (G9().p4(e16)) {
                                this.F.e2(G9().getIsBubbleShowed());
                                return;
                            }
                            final com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(ra5.getContext());
                            NonScrollableScrollView nonScrollableScrollView = this.menuScrollView;
                            if (nonScrollableScrollView != null) {
                                i3 = nonScrollableScrollView.getScrollY();
                            } else {
                                i3 = 0;
                            }
                            int bottom = ra5.getBottom() - i3;
                            String tag = getTAG();
                            int bottom2 = ra5.getBottom();
                            int height = this.D.getHeight();
                            int height2 = ra5.getHeight();
                            ConstraintLayout constraintLayout = this.parentLayout;
                            if (constraintLayout != null) {
                                num = Integer.valueOf(constraintLayout.getHeight());
                            } else {
                                num = null;
                            }
                            w53.b.a(tag, "scrollerY:" + i3 + " enhanceView.bottom:" + bottom2 + " mMenuBar.height:" + height + " enhanceView.height:" + height2 + " parentLayout:" + num);
                            ConstraintLayout constraintLayout2 = this.parentLayout;
                            Intrinsics.checkNotNull(constraintLayout2);
                            if (bottom <= constraintLayout2.getHeight() && bottom > ra5.getHeight()) {
                                r16.o0(e16.getTipsString());
                                r16.m0(3);
                                r16.k0(2);
                                r16.R(1);
                                r16.S(ra5);
                                r16.s0();
                                r16.g0(false);
                                G9().r5();
                                companion.g(e16);
                                Ua(e16.getName(), r16.v());
                                r16.v().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.ac
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        aq.cc(com.tencent.mobileqq.widget.tip.a.this, view);
                                    }
                                });
                                this.F.e2(true);
                                Ya(ra5);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u
    protected void cb(@NotNull WinkBubbleInfo bubbleInfo) {
        com.tencent.mobileqq.widget.tip.a aVar;
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        w53.b.a(getTAG(), "startDisplayNewPopup... " + bubbleInfo);
        if (G9().p4(bubbleInfo)) {
            return;
        }
        if (this.J && (aVar = this.K) != null) {
            aVar.o();
        }
        a.Companion companion = a63.a.INSTANCE;
        MenuItem b16 = companion.b(bubbleInfo);
        if (b16 == null) {
            return;
        }
        View qa5 = qa(b16);
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(qa5.getContext());
        this.K = r16;
        r16.o0(bubbleInfo.getTipsString());
        this.J = true;
        companion.g(bubbleInfo);
        G9().r5();
        this.K.m0(3);
        this.K.k0(2);
        this.K.R(1);
        this.K.S(qa5);
        this.K.s0();
        this.K.f(new e());
        Ua(bubbleInfo.getName(), this.K.v());
        Ta(qa5, bubbleInfo.getName());
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u
    public void fb(boolean isHDROn) {
        int i3;
        View findViewWithTag = this.D.findViewWithTag(MenuType.ENHANCE);
        if (findViewWithTag instanceof TextView) {
            TextView textView = (TextView) findViewWithTag;
            if (isHDROn) {
                i3 = R.drawable.m4g;
            } else {
                i3 = R.drawable.m4e;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i3, 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "VerticalDashboardMenuPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return v.d();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w53.b.a(getTAG(), "onConfigurationChanged...");
        G9().I4();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u
    @Nullable
    protected View sa() {
        return this.menuScrollView;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u
    protected void ua(@Nullable List<? extends MenuItem> items) {
        List<? extends MenuItem> list;
        int size;
        Integer num;
        int min;
        int i3;
        int i16;
        float f16;
        ConstraintLayout constraintLayout;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator rotation;
        ViewPropertyAnimator duration;
        ViewGroup.LayoutParams layoutParams;
        if (items == null) {
            return;
        }
        Wb();
        if (v.c()) {
            list = v.e(items);
        } else {
            list = items;
        }
        if (this.currentMenuItem.isEmpty()) {
            this.currentMenuItem = list;
            this.D.removeAllViews();
            this.H.clear();
        } else if (!Intrinsics.areEqual(this.currentMenuItem, list)) {
            this.currentMenuItem = list;
            this.expand = false;
            NonScrollableScrollView nonScrollableScrollView = this.menuScrollView;
            if (nonScrollableScrollView != null) {
                nonScrollableScrollView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.menu.ah
                    @Override // java.lang.Runnable
                    public final void run() {
                        aq.Vb(aq.this);
                    }
                });
            }
            this.D.removeAllViews();
            this.H.clear();
        }
        if (list.size() > 6) {
            size = 6;
        } else {
            size = list.size();
        }
        int i17 = this.padding;
        int i18 = this.menuHeight;
        int i19 = (i17 * 2) + (i18 * size) + (this.gapHeight * (size - 1)) + this.foldIconGapHeight + this.iconWidth;
        int size2 = (i17 * 2) + (i18 * list.size()) + (this.gapHeight * (list.size() - 1)) + this.foldIconGapHeight + this.iconWidth;
        com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int f17 = (oVar.f(context) - e83.a.d(72)) - e83.a.d(46);
        int i26 = this.padding;
        int i27 = this.menuHeight;
        int i28 = i26 + (i27 * 8) + (this.gapHeight * 8) + this.foldIconGapHeight + this.iconWidth + (i27 / 2);
        String tag = getTAG();
        int size3 = items.size();
        int childCount = this.D.getChildCount();
        ConstraintLayout constraintLayout2 = this.parentLayout;
        if (constraintLayout2 != null && (layoutParams = constraintLayout2.getLayoutParams()) != null) {
            num = Integer.valueOf(layoutParams.height);
        } else {
            num = null;
        }
        w53.b.f(tag, "items size:" + size3 + " collapsedHeight:" + i19 + " expandHeight:" + size2 + " screenHeight:" + f17 + " limitHeight:" + i28 + " mMenuBar.childCount:" + childCount + " collapsedSize:" + size + " parentLayout.height:" + num + " expand:" + this.expand + " density:" + ImmersiveUtils.getDensity());
        if (size2 > i28) {
            min = Math.min(f17, i28);
        } else {
            min = Math.min(f17, size2);
        }
        Xb(list, min, i19);
        NonScrollableScrollView nonScrollableScrollView2 = this.menuScrollView;
        if (nonScrollableScrollView2 != null) {
            nonScrollableScrollView2.setScrollingEnabled(this.expand);
        }
        if (list.size() <= 6) {
            ImageView imageView = this.arrowImageView;
            i3 = 8;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            i16 = 0;
        } else {
            i3 = 8;
            ImageView imageView2 = this.arrowImageView;
            i16 = 0;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        Zb(min, i19);
        if (this.expand) {
            f16 = 180.0f;
        } else {
            f16 = 0.0f;
        }
        ImageView imageView3 = this.arrowImageView;
        if (imageView3 != null && (animate = imageView3.animate()) != null && (rotation = animate.rotation(f16)) != null && (duration = rotation.setDuration(this.animatorDuration)) != null) {
            duration.start();
        }
        if (G9().a2()) {
            MenuType menuType = MenuType.VIDEO_FIRST_TEMPLATE;
            if (ra(menuType) != null && (constraintLayout = this.parentLayout) != null) {
                if (G9().getCurMenuType() != menuType) {
                    i3 = i16;
                }
                constraintLayout.setVisibility(i3);
            }
        }
        if (G9().Z3()) {
            gb();
        }
        Wa();
        Za();
        Xa();
        bb();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u
    protected boolean va(@Nullable View child, @Nullable View parent) {
        Integer num;
        int i3;
        if (child == null || parent == null) {
            return false;
        }
        String tag = getTAG();
        int bottom = child.getBottom();
        int bottom2 = parent.getBottom();
        int height = parent.getHeight();
        NonScrollableScrollView nonScrollableScrollView = this.menuScrollView;
        if (nonScrollableScrollView != null) {
            num = Integer.valueOf(nonScrollableScrollView.getScrollY());
        } else {
            num = null;
        }
        w53.b.a(tag, "itemExposed... child.bottom:" + bottom + " parent.bottom:" + bottom2 + " parent.height:" + height + " menuScrollView.scrollY:" + num);
        int bottom3 = child.getBottom();
        int height2 = parent.getHeight();
        NonScrollableScrollView nonScrollableScrollView2 = this.menuScrollView;
        if (nonScrollableScrollView2 != null) {
            i3 = nonScrollableScrollView2.getScrollY();
        } else {
            i3 = 0;
        }
        if (bottom3 > height2 + i3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.u, com.tencent.mobileqq.wink.editor.d
    public void z9(@NotNull View rootView) {
        ViewParent viewParent;
        ImageView imageView;
        ViewParent viewParent2;
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        LinearLayout linearLayout = (LinearLayout) getPartRootView();
        this.D = linearLayout;
        ViewParent parent = linearLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.view.NonScrollableScrollView");
        NonScrollableScrollView nonScrollableScrollView = (NonScrollableScrollView) parent;
        this.menuScrollView = nonScrollableScrollView;
        ImageView imageView2 = null;
        if (nonScrollableScrollView != null) {
            viewParent = nonScrollableScrollView.getParent();
        } else {
            viewParent = null;
        }
        Intrinsics.checkNotNull(viewParent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewParent;
        this.parentLayout = constraintLayout2;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        ConstraintLayout constraintLayout3 = this.parentLayout;
        if (constraintLayout3 != null && (imageView = (ImageView) constraintLayout3.findViewById(R.id.f74643wt)) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    aq.Hb(aq.this, view);
                }
            });
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Option obtain = Option.obtain();
            obtain.setUrl("https://qq-video.cdn-go.cn/ios/latest/defaultmode/915/editor/icon_editor_function_unfold.png");
            obtain.setLoadingDrawableColor(0);
            obtain.setRequestWidth(this.iconWidth);
            obtain.setRequestHeight(this.iconWidth);
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026= iconWidth\n            }");
            qQPicLoader.e(obtain, new b(imageView, this));
        } else {
            imageView = null;
        }
        this.arrowImageView = imageView;
        ConstraintLayout constraintLayout4 = this.parentLayout;
        if (constraintLayout4 != null) {
            viewParent2 = constraintLayout4.getParent();
        } else {
            viewParent2 = null;
        }
        if (viewParent2 instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) viewParent2;
        } else {
            constraintLayout = null;
        }
        if (constraintLayout != null) {
            imageView2 = (ImageView) constraintLayout.findViewById(R.id.f74393w5);
        }
        this.bgImageView = imageView2;
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option obtain2 = Option.obtain();
        obtain2.setUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/915/editor/qvideo_editor_vertical_safearea.png");
        obtain2.setLoadingDrawableColor(0);
        g16.loadImage(obtain2, new c());
        initViewModel();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/menu/aq$e", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements a.b {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            aq aqVar = aq.this;
            aqVar.J = false;
            aqVar.K = null;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/menu/aq$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            NonScrollableScrollView nonScrollableScrollView = aq.this.menuScrollView;
            if (nonScrollableScrollView != null) {
                nonScrollableScrollView.smoothScrollTo(0, 0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
