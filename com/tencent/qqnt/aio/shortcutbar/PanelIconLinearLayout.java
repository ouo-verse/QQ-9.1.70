package com.tencent.qqnt.aio.shortcutbar;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.shortcutbar.widget.CountImageView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0013B\u0013\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105B\u001d\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b4\u00108B%\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00109\u001a\u00020\u0006\u00a2\u0006\u0004\b4\u0010:J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020 H\u0016J\u0010\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%J\u0012\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0014R\u0018\u0010,\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00100\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/aio/shortcutbar/PanelIconLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "view", "", "panelId", "", "d", "count", "g", "chatType", "", "peerUid", "Lcom/tencent/qqnt/aio/shortcutbar/h;", "panelCallback", "f", "Lkotlin/Pair;", "a", "type", "c", "Lcom/tencent/qqnt/aio/shortcutbar/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/widget/ImageView;", "b", "v", NodeProps.ON_CLICK, "", NodeProps.ON_LONG_CLICK, "setSelected", "e", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "Lcom/tencent/qqnt/aio/shortcutbar/g;", "listener", "setInterceptListener", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Lcom/tencent/qqnt/aio/shortcutbar/g;", "mInterceptListener", "Lcom/tencent/qqnt/aio/shortcutbar/h;", "mPanelCallback", "Lcom/tencent/qqnt/aio/shortcutbar/widget/CountImageView;", "Lcom/tencent/qqnt/aio/shortcutbar/widget/CountImageView;", "photoPanelShortcutView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PanelIconLinearLayout extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mInterceptListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h mPanelCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountImageView photoPanelShortcutView;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/shortcutbar/PanelIconLinearLayout$a;", "", "", "b", "Landroid/content/Context;", "context", "isExpanded", "", "a", "TAG", "Ljava/lang/String;", "", "dividerWidth", UserInfo.SEX_FEMALE, "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.shortcutbar.PanelIconLinearLayout$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a(@NotNull Context context, boolean isExpanded) {
            String string;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(isExpanded));
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (isExpanded) {
                string = context.getString(R.string.f197494k6);
                str = "context.getString(R.string.qq_aio_panel_expand)";
            } else {
                string = context.getString(R.string.f197484k5);
                str = "context.getString(R.string.qq_aio_panel_collapse)";
            }
            Intrinsics.checkNotNullExpressionValue(string, str);
            return string;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return true;
            }
            return false;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PanelIconLinearLayout(@Nullable Context context) {
        super(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final void d(View view, int panelId) {
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && INSTANCE.b() && panelId != 1005) {
            ViewCompat.setAccessibilityDelegate(view, new l());
        }
    }

    @Nullable
    public final Pair<Integer, Integer> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            Integer num = null;
            if (i3 >= childCount) {
                return null;
            }
            View childAt = getChildAt(i3);
            Object tag = childAt.getTag();
            if (tag instanceof Integer) {
                num = (Integer) tag;
            }
            if (num != null && num.intValue() == 1006) {
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                return new Pair<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            }
            i3++;
        }
    }

    @NotNull
    public final ImageView b(@NotNull a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ImageView) iPatchRedirector.redirect((short) 8, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        ImageView imageView = new ImageView(getContext());
        if (item.b() != null) {
            imageView.setImageDrawable(item.b());
        }
        imageView.setTag(Integer.valueOf(item.c()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewUtils.dpToPx(28.0f));
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        imageView.setContentDescription(item.a());
        imageView.setOnClickListener(this);
        return imageView;
    }

    @Nullable
    public final View c(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, type);
        }
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            Integer num = null;
            if (i3 >= childCount) {
                return null;
            }
            View childAt = getChildAt(i3);
            Object tag = childAt.getTag();
            if (tag instanceof Integer) {
                num = (Integer) tag;
            }
            if (num != null && num.intValue() == type) {
                return childAt;
            }
            i3++;
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                childAt.isSelected();
                childAt.setSelected(false);
                childAt.isSelected();
            }
        }
    }

    public final void f(int chatType, @NotNull String peerUid, @NotNull h panelCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(chatType), peerUid, panelCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(panelCallback, "panelCallback");
        this.mPanelCallback = panelCallback;
        removeAllViews();
        for (a aVar : k.f352115a.a(chatType).a(chatType, peerUid)) {
            if (aVar.c() != 1003) {
                ImageView b16 = b(aVar);
                d(b16, aVar.c());
                addView(b16);
            } else {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                CountImageView countImageView = new CountImageView(context);
                countImageView.setTag(Integer.valueOf(aVar.c()));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                layoutParams.weight = 1.0f;
                layoutParams.gravity = 16;
                countImageView.setLayoutParams(layoutParams);
                if (aVar.b() != null) {
                    countImageView.setImageDrawable(aVar.b());
                }
                countImageView.setOnClickListener(this);
                countImageView.setOnLongClickListener(this);
                countImageView.setContentDescription(aVar.a());
                countImageView.setScaleType(ImageView.ScaleType.CENTER);
                d(countImageView, aVar.c());
                this.photoPanelShortcutView = countImageView;
                addView(countImageView);
            }
        }
    }

    public final void g(int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, count);
            return;
        }
        CountImageView countImageView = this.photoPanelShortcutView;
        if (countImageView != null) {
            countImageView.setNum(count);
        }
        CountImageView countImageView2 = this.photoPanelShortcutView;
        if (countImageView2 != null) {
            countImageView2.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            h hVar = this.mPanelCallback;
            if (hVar != null) {
                hVar.l0(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        g gVar = this.mInterceptListener;
        if (gVar != null) {
            return gVar.interceptTouchEvent(ev5);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) v3)).booleanValue();
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            h hVar = this.mPanelCallback;
            if (hVar != null) {
                z16 = hVar.c0(v3);
            } else {
                z16 = false;
            }
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        g gVar = this.mInterceptListener;
        if (gVar != null) {
            return gVar.handleTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public final void setInterceptListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener);
        } else {
            this.mInterceptListener = listener;
        }
    }

    public final void setSelected(int panelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, panelId);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            childAt.isSelected();
            childAt.setSelected(Intrinsics.areEqual(childAt.getTag(), Integer.valueOf(panelId)));
            childAt.isSelected();
        }
    }

    public PanelIconLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setOrientation(0);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public PanelIconLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
