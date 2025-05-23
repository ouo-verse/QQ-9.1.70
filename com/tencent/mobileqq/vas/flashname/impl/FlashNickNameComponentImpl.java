package com.tencent.mobileqq.vas.flashname.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.api.IUnitedData;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import com.tencent.mobileqq.vas.nickCover.NickCoverAnimationView;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J]\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\"\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016JE\u0010#\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0016Jg\u0010\"\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00042#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J=\u0010'\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/vas/flashname/impl/FlashNickNameComponentImpl;", "Lcom/tencent/mobileqq/vas/flashname/IFlashNickNameComponent;", "", "enableNickCoverAnimation", "", "getAnimationUrl", "Landroid/view/View;", "view", "noNeedAdd", LayoutAttrDefine.ALIGN_LEFT, "", "width", "isCenter", "animationUrl", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isViewLayoutRightInvoke", "Lcom/tencent/mobileqq/vas/flashname/IFlashNickNameComponent$a;", "listener", "addNickCoverLocal", "isViewLayoutRight", "alreadyAddedView", "height", "colorValue", "isSingle", "Lx03/b;", "createFlashNickName", "Lcom/tencent/qqnt/msg/d;", "msg", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "nickCoverKeyWordsDetect", "playNickCoverAnimation", "playNickCoverAnimationWithSimpleMode", "loop", "isClipView", "scene", "addNickCover", "removeNickCover", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class FlashNickNameComponentImpl implements IFlashNickNameComponent {

    @NotNull
    private static final String TAG = "FlashNickNameComponentImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/flashname/impl/FlashNickNameComponentImpl$b", "Lcom/tencent/mobileqq/vas/nickCover/NickCoverAnimationView$a;", "", "onAnimEnd", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements NickCoverAnimationView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IFlashNickNameComponent.a f309081a;

        b(IFlashNickNameComponent.a aVar) {
            this.f309081a = aVar;
        }

        @Override // com.tencent.mobileqq.vas.nickCover.NickCoverAnimationView.a
        public void onAnimEnd() {
            IFlashNickNameComponent.a aVar = this.f309081a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private final View addNickCoverLocal(View view, int width, boolean isCenter, String animationUrl, Function1<? super View, Boolean> isViewLayoutRightInvoke, IFlashNickNameComponent.a listener) {
        int measuredHeight;
        ViewParent viewParent;
        ViewParent viewParent2;
        boolean isViewLayoutRight;
        boolean isViewLayoutRight2;
        ViewParent parent = view.getParent();
        View alreadyAddedView = alreadyAddedView(view);
        if (alreadyAddedView != null) {
            return alreadyAddedView;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        NickCoverAnimationView nickCoverAnimationView = new NickCoverAnimationView(context, animationUrl);
        nickCoverAnimationView.setAnimEndListener(new b(listener));
        nickCoverAnimationView.setId(R.id.f116416yo);
        try {
            measuredHeight = (int) (((view.getMeasuredHeight() * 1.0f) / 24) * 27);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "addNickCoverLocal error", e16);
        }
        if (parent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (measuredHeight * 3.18f), measuredHeight);
            if (isCenter) {
                layoutParams.addRule(13);
            } else {
                layoutParams.addRule(5, view.getId());
                layoutParams.addRule(6, view.getId());
            }
            if (width > 0) {
                ((ViewGroup.LayoutParams) layoutParams).width = width;
            }
            ((RelativeLayout) parent).addView(nickCoverAnimationView, layoutParams);
            if (isViewLayoutRightInvoke == null) {
                return null;
            }
            return nickCoverAnimationView;
        }
        if (parent != null) {
            viewParent = parent.getParent();
        } else {
            viewParent = null;
        }
        int i3 = 0;
        if (viewParent instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (measuredHeight * 3.18f), measuredHeight);
            if (isViewLayoutRightInvoke != null) {
                Object parent2 = parent.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
                isViewLayoutRight2 = isViewLayoutRightInvoke.invoke((View) parent2).booleanValue();
            } else {
                Object parent3 = parent.getParent();
                Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type android.view.View");
                isViewLayoutRight2 = isViewLayoutRight((View) parent3);
            }
            if (isViewLayoutRight2) {
                layoutParams2.gravity = 5;
                Object parent4 = parent.getParent();
                Intrinsics.checkNotNull(parent4, "null cannot be cast to non-null type android.view.View");
                int right = ((View) parent4).getRight();
                Object parent5 = parent.getParent();
                Intrinsics.checkNotNull(parent5, "null cannot be cast to non-null type android.view.View");
                int left = (right - ((View) parent5).getLeft()) - view.getRight();
                if (left > 0) {
                    i3 = left;
                }
                layoutParams2.rightMargin = i3;
            } else {
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt = ((ViewGroup) parent).getChildAt(0);
                if (childAt instanceof FrameLayout) {
                    layoutParams2.leftMargin = ((FrameLayout) childAt).getWidth();
                }
            }
            if (width > 0) {
                ((ViewGroup.LayoutParams) layoutParams2).width = width;
            }
            ViewParent parent6 = parent.getParent();
            Intrinsics.checkNotNull(parent6, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent6).addView(nickCoverAnimationView, layoutParams2);
            return nickCoverAnimationView;
        }
        if (parent != null) {
            viewParent2 = parent.getParent();
        } else {
            viewParent2 = null;
        }
        if (viewParent2 instanceof ConstraintLayout) {
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams((int) (measuredHeight * 3.18f), measuredHeight);
            if (isViewLayoutRightInvoke != null) {
                Object parent7 = parent.getParent();
                Intrinsics.checkNotNull(parent7, "null cannot be cast to non-null type android.view.View");
                isViewLayoutRight = isViewLayoutRightInvoke.invoke((View) parent7).booleanValue();
            } else {
                Object parent8 = parent.getParent();
                Intrinsics.checkNotNull(parent8, "null cannot be cast to non-null type android.view.View");
                isViewLayoutRight = isViewLayoutRight((View) parent8);
            }
            if (view.getId() > 0) {
                layoutParams3.topToTop = view.getId();
                nickCoverAnimationView.setTranslationY((-(measuredHeight - view.getMeasuredHeight())) / 2.0f);
            }
            if (isViewLayoutRight) {
                layoutParams3.rightToRight = 0;
                Object parent9 = parent.getParent();
                Intrinsics.checkNotNull(parent9, "null cannot be cast to non-null type android.view.View");
                int right2 = ((View) parent9).getRight();
                Object parent10 = parent.getParent();
                Intrinsics.checkNotNull(parent10, "null cannot be cast to non-null type android.view.View");
                int left2 = (right2 - ((View) parent10).getLeft()) - view.getRight();
                if (left2 > 0) {
                    i3 = left2;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = i3;
            } else {
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt2 = ((ViewGroup) parent).getChildAt(0);
                if (childAt2 instanceof FrameLayout) {
                    ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = ((FrameLayout) childAt2).getWidth();
                }
            }
            if (width > 0) {
                ((ViewGroup.LayoutParams) layoutParams3).width = width;
            }
            ViewParent parent11 = parent.getParent();
            Intrinsics.checkNotNull(parent11, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent11).addView(nickCoverAnimationView, layoutParams3);
            return nickCoverAnimationView;
        }
        return null;
    }

    static /* synthetic */ View addNickCoverLocal$default(FlashNickNameComponentImpl flashNickNameComponentImpl, View view, int i3, boolean z16, String str, Function1 function1, IFlashNickNameComponent.a aVar, int i16, Object obj) {
        Function1 function12;
        IFlashNickNameComponent.a aVar2;
        if ((i16 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i16 & 32) != 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        return flashNickNameComponentImpl.addNickCoverLocal(view, i3, z16, str, function12, aVar2);
    }

    private final boolean alignLeft() {
        if (QQTheme.isNowSimpleUI()) {
            return true;
        }
        return ((IUnitedData) QRoute.api(IUnitedData.class)).isSwitchOn("aio_title_align_left_9000_887617015", true);
    }

    private final View alreadyAddedView(View view) {
        ViewParent viewParent;
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof RelativeLayout)) {
            return ((ViewGroup) parent).findViewById(R.id.f116416yo);
        }
        if (parent != null) {
            viewParent = parent.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && (viewParent instanceof FrameLayout)) {
            return ((ViewGroup) viewParent).findViewById(R.id.f116416yo);
        }
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            return null;
        }
        return ((ViewGroup) viewParent).findViewById(R.id.f116416yo);
    }

    private final boolean enableNickCoverAnimation() {
        UnitedProxy unitedProxy = VasNtToggle.VAS_NICK_COVER_ANIMATION;
        if (!unitedProxy.isEnable(false)) {
            return false;
        }
        JSONObject json = unitedProxy.getJson();
        try {
            int optInt = json.optInt("start_time");
            int optInt2 = json.optInt("end_time");
            long serverTime = NetConnInfoCenter.getServerTime();
            if (optInt > serverTime || serverTime > optInt2) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "enableNickCoverAnimation error", e16);
            return false;
        }
    }

    private final String getAnimationUrl() {
        String optString = VasNtToggle.VAS_NICK_COVER_ANIMATION.getJson().optString("image_url");
        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"image_url\")");
        return optString;
    }

    private final boolean isViewLayoutRight(View view) {
        if (ViewUtils.f352270a.e() - view.getRight() < view.getLeft()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nickCoverKeyWordsDetect$lambda$2(com.tencent.aio.api.runtime.a aVar) {
        j e16;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new AIOTitleEvent.PlayChatNickCoverAnimationEvent(null, 1, null));
        }
    }

    private final boolean noNeedAdd(View view) {
        if (view.getParent() instanceof RelativeLayout) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playNickCoverAnimation$lambda$5(FlashNickNameComponentImpl this$0, boolean z16, boolean z17, String animationUrl, Function1 function1, IFlashNickNameComponent.a aVar, int i3, String scene, View view, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animationUrl, "$animationUrl");
        Intrinsics.checkNotNullParameter(scene, "$scene");
        if (view == null || i18 - i16 <= 0 || i28 - i26 > 0) {
            return;
        }
        KeyEvent.Callback addNickCoverLocal = this$0.addNickCoverLocal(view, z16 ? view.getMeasuredWidth() : -1, z17, animationUrl, function1, aVar);
        if (addNickCoverLocal == null || !(addNickCoverLocal instanceof com.tencent.mobileqq.vas.api.b)) {
            return;
        }
        ((com.tencent.mobileqq.vas.api.b) addNickCoverLocal).a(i3, z16, scene);
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    public void addNickCover(@NotNull View view, @NotNull String animationUrl, @Nullable Function1<? super View, Boolean> isViewLayoutRightInvoke) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(animationUrl, "animationUrl");
        if (alreadyAddedView(view) != null) {
            return;
        }
        addNickCoverLocal$default(this, view, -1, !alignLeft(), animationUrl, isViewLayoutRightInvoke, null, 32, null);
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    @NotNull
    public x03.b createFlashNickName(int width, int height, @NotNull String colorValue, boolean isSingle, @NotNull View view) {
        Intrinsics.checkNotNullParameter(colorValue, "colorValue");
        Intrinsics.checkNotNullParameter(view, "view");
        return new c(width, height, colorValue, isSingle, view);
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    public void nickCoverKeyWordsDetect(@NotNull d msg2, @Nullable final com.tencent.aio.api.runtime.a aioContext) {
        boolean contains$default;
        String content;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!enableNickCoverAnimation()) {
            return;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            QLog.i(TAG, 1, "simple Ui, no support keyword tips");
            return;
        }
        JSONArray optJSONArray = VasNtToggle.VAS_NICK_COVER_ANIMATION.getJson().optJSONArray("keywords");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                Intrinsics.checkNotNullExpressionValue(optString, "keywords.optString(i)");
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        String str = "";
        try {
            Iterator it = new ArrayList(msg2.a().elements).iterator();
            while (it.hasNext()) {
                TextElement textElement = ((MsgElement) it.next()).textElement;
                if (textElement != null && (content = textElement.content) != null) {
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    if (!TextUtils.isEmpty(content)) {
                        str = ((Object) str) + content;
                    }
                }
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "E:" + e16);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int size = arrayList.size();
        for (int i16 = 0; i16 < size; i16++) {
            Object obj = arrayList.get(i16);
            Intrinsics.checkNotNullExpressionValue(obj, "filter[i]");
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str2, false, 2, (Object) null);
                if (contains$default) {
                    QLog.d(TAG, 4, "detected Keyword, keyword=" + str2);
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.flashname.impl.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlashNickNameComponentImpl.nickCoverKeyWordsDetect$lambda$2(com.tencent.aio.api.runtime.a.this);
                        }
                    }, 16, null, false, 1000L);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    public void playNickCoverAnimation(@NotNull View view, boolean isCenter) {
        Intrinsics.checkNotNullParameter(view, "view");
        playNickCoverAnimationWithSimpleMode(view, isCenter, getAnimationUrl(), null);
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    public void playNickCoverAnimationWithSimpleMode(@NotNull View view, boolean isCenter, @NotNull String animationUrl, @Nullable Function1<? super View, Boolean> isViewLayoutRightInvoke) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(animationUrl, "animationUrl");
        if (SimpleUIUtil.getSimpleUISwitch() && !enableNickCoverAnimation()) {
            QLog.e(TAG, 1, "playNickCoverAnimation not enable");
        } else {
            if (noNeedAdd(view)) {
                return;
            }
            playNickCoverAnimation(view, isCenter, animationUrl, 1, false, "", isViewLayoutRightInvoke, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    public void removeNickCover(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View alreadyAddedView = alreadyAddedView(view);
        if (alreadyAddedView != null) {
            try {
                alreadyAddedView.setVisibility(4);
                ViewParent parent = view.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(alreadyAddedView);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "removeNickCover error", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    public void playNickCoverAnimation(@NotNull View view, final boolean isCenter, @NotNull final String animationUrl, final int loop, final boolean isClipView, @NotNull final String scene, @Nullable final Function1<? super View, Boolean> isViewLayoutRightInvoke, @Nullable final IFlashNickNameComponent.a listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(animationUrl, "animationUrl");
        Intrinsics.checkNotNullParameter(scene, "scene");
        KeyEvent.Callback alreadyAddedView = alreadyAddedView(view);
        if (alreadyAddedView != null) {
            ((com.tencent.mobileqq.vas.api.b) alreadyAddedView).a(loop, isClipView, scene);
            return;
        }
        if ((view.getHeight() <= 0 || view.getMeasuredHeight() <= 0) && view.getVisibility() == 0) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.vas.flashname.impl.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    FlashNickNameComponentImpl.playNickCoverAnimation$lambda$5(FlashNickNameComponentImpl.this, isClipView, isCenter, animationUrl, isViewLayoutRightInvoke, listener, loop, scene, view2, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
            return;
        }
        KeyEvent.Callback addNickCoverLocal = addNickCoverLocal(view, isClipView ? view.getMeasuredWidth() : -1, isCenter, animationUrl, isViewLayoutRightInvoke, listener);
        if (addNickCoverLocal == null || !(addNickCoverLocal instanceof com.tencent.mobileqq.vas.api.b)) {
            return;
        }
        ((com.tencent.mobileqq.vas.api.b) addNickCoverLocal).a(loop, isClipView, scene);
    }

    @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent
    public void addNickCover(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        IFlashNickNameComponent.b.a(this, view, getAnimationUrl(), null, 4, null);
    }
}
