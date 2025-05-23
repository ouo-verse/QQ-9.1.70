package com.tencent.mobileqq.aio.robot.titlebar;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.title.AIOTitleUIState;
import com.tencent.mobileqq.aio.title.AIOTitleVM;
import com.tencent.mobileqq.aio.title.ah;
import com.tencent.mobileqq.aio.title.am;
import com.tencent.mobileqq.aio.title.center.CenterVB;
import com.tencent.mobileqq.aio.title.n;
import com.tencent.mobileqq.aio.title.right2.Right2VB;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.aio.widget.QUIBadgeMosaic;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.t;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.t;
import w71.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030*H\u0016J&\u00100\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020.\u0012\u0006\b\u0001\u0012\u00020/0\u00010-2\u0006\u0010,\u001a\u00020'H\u0016J\u0016\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u0003010-H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0003H\u0016J\b\u00105\u001a\u00020\u0004H\u0016R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/n;", "Lcom/tencent/mobileqq/aio/title/AIOTitleUIState;", "", "q1", "v1", "Lcom/tencent/mobileqq/aio/title/ah;", "data", Constants.BASE_IN_PLUGIN_ID, "", "visiable", "", "type", "F1", "y1", "z1", "l1", "isSelectMode", "isScaleChat", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/aio/title/am;", Constants.APK_CERTIFICATE, "isSelectedMode", "I1", "needTransparentBg", "H1", "", "unreadCount", "needAnim", "isUseTextColorCache", "J1", "w1", "j1", "C1", "B1", "A1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "p1", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Ljava/lang/Class;", "getObserverStates", "state", "u1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lw71/t;", "d", "Lw71/t;", "mTitleBinding", "Lw71/u;", "e", "Lw71/u;", "mRight3IvBinding", "Lcom/tencent/mobileqq/aio/title/center/CenterVB;", "f", "Lcom/tencent/mobileqq/aio/title/center/CenterVB;", "mCenterVB", "<init>", "()V", tl.h.F, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotAIOTitleVB extends com.tencent.aio.base.mvvm.a<n, AIOTitleUIState> {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f193613h = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private t mTitleBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private u mRight3IvBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CenterVB mCenterVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void A1() {
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            t tVar = this.mTitleBinding;
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar = null;
            }
            tVar.f444905f.performAccessibilityAction(64, new Bundle());
        }
    }

    private final void B1() {
        t tVar = null;
        n.b bVar = new n.b(null, 1, null);
        sendIntent(bVar);
        View.AccessibilityDelegate a16 = bVar.a();
        if (a16 != null) {
            t tVar2 = this.mTitleBinding;
            if (tVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            } else {
                tVar = tVar2;
            }
            tVar.f444911l.setAccessibilityDelegate(a16);
        }
    }

    private final void C1(boolean needTransparentBg) {
        int i3;
        if (!QQTheme.isNowSimpleUI() && !QQTheme.isVasTheme() && !needTransparentBg) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        tVar.f444903d.setVisibility(i3);
    }

    private final void D1(ah data) {
        boolean z16;
        v1();
        if (data.e() && !data.f()) {
            z16 = true;
        } else {
            z16 = false;
        }
        F1(z16, data.c());
        Function1<View, Unit> d16 = data.d();
        u uVar = null;
        if (d16 != null) {
            u uVar2 = this.mRight3IvBinding;
            if (uVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                uVar2 = null;
            }
            RedDotImageView redDotImageView = uVar2.f444920b;
            Intrinsics.checkNotNullExpressionValue(redDotImageView, "mRight3IvBinding.right3Iv");
            d16.invoke(redDotImageView);
        }
        u uVar3 = this.mRight3IvBinding;
        if (uVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar3 = null;
        }
        uVar3.f444920b.setShowRedDot(data.a());
        u uVar4 = this.mRight3IvBinding;
        if (uVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar4 = null;
        }
        uVar4.f444920b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotAIOTitleVB.E1(RobotAIOTitleVB.this, view);
            }
        });
        if (data.b() != null) {
            u uVar5 = this.mRight3IvBinding;
            if (uVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            } else {
                uVar = uVar5;
            }
            uVar.f444920b.setImageDrawable(data.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(RobotAIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.m.f193986d);
        this$0.z1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void F1(boolean visiable, String type) {
        int i3;
        y1(visiable, type);
        u uVar = this.mRight3IvBinding;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar = null;
        }
        RedDotImageView redDotImageView = uVar.f444920b;
        if (visiable) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        redDotImageView.setVisibility(i3);
    }

    private final void G1(am data) {
        J1(data.c(), data.d(), false, data.e());
        I1(data.b(), data.d());
        H1(data.b(), data.a());
        C1(data.a());
    }

    private final void H1(boolean isScaleChat, boolean needTransparentBg) {
        t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        RelativeLayout relativeLayout = tVar.f444910k;
        int i3 = 0;
        if (needTransparentBg) {
            relativeLayout.setBackgroundColor(0);
        } else if (QQTheme.isVasTheme()) {
            AIOUtil.f194084a.G(relativeLayout, R.drawable.qui_common_bg_nav_aio_bg);
        } else {
            AIOUtil.f194084a.F(relativeLayout, new ColorDrawable(relativeLayout.getResources().getColor(R.color.qui_common_bg_nav_aio)));
        }
        if (isScaleChat) {
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), (int) relativeLayout.getResources().getDimension(R.dimen.dbx), relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        } else {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                i3 = ImmersiveUtils.getStatusBarHeight(relativeLayout.getContext());
            }
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), i3, relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        }
    }

    private final void I1(boolean isScaleChat, boolean isSelectedMode) {
        String str;
        t tVar = null;
        if (!isSelectedMode) {
            if (isScaleChat) {
                t tVar2 = this.mTitleBinding;
                if (tVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar2 = null;
                }
                tVar2.f444905f.setBackgroundResource(R.drawable.qui_close_icon_navigation_01);
            } else {
                Drawable drawable = ContextCompat.getDrawable(getMContext(), R.drawable.qui_chevron_left_icon_navigation_02_selector);
                t tVar3 = this.mTitleBinding;
                if (tVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar3 = null;
                }
                tVar3.f444905f.setBackground(drawable);
            }
            t tVar4 = this.mTitleBinding;
            if (tVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar4 = null;
            }
            tVar4.f444905f.setTextColor(getMContext().getColor(R.color.skin_bar_btn));
        }
        t tVar5 = this.mTitleBinding;
        if (tVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar5 = null;
        }
        if (!TextUtils.isEmpty(tVar5.f444916q.a())) {
            Resources resources = getMContext().getResources();
            Object[] objArr = new Object[1];
            t tVar6 = this.mTitleBinding;
            if (tVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar6 = null;
            }
            objArr[0] = tVar6.f444916q.a();
            str = resources.getString(R.string.yt8, objArr);
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (!TextUtils.isEmpty(m\u2026\n            \"\"\n        }");
        t tVar7 = this.mTitleBinding;
        if (tVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            tVar = tVar7;
        }
        tVar.f444905f.setContentDescription(HardCodeUtil.qqStr(R.string.yt7) + str);
    }

    private final void J1(int unreadCount, boolean isSelectedMode, boolean needAnim, boolean isUseTextColorCache) {
        int a16;
        boolean z16;
        int a17;
        String str;
        t tVar = this.mTitleBinding;
        t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        tVar.f444916q.setTextColorUseCache(isUseTextColorCache);
        t tVar3 = this.mTitleBinding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar3 = null;
        }
        tVar3.f444916q.setAIOBarNum(unreadCount);
        t tVar4 = this.mTitleBinding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar4 = null;
        }
        ViewGroup.LayoutParams layoutParams = tVar4.f444905f.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i3 = 8;
        if (isSelectedMode) {
            t tVar5 = this.mTitleBinding;
            if (tVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar5 = null;
            }
            QUIBadgeMosaic qUIBadgeMosaic = tVar5.f444916q;
            if (unreadCount > 0) {
                i3 = 0;
            }
            qUIBadgeMosaic.setTag(Integer.valueOf(i3));
            layoutParams2.setMarginEnd(x.a(8.0f));
        } else {
            if (needAnim && unreadCount > 0) {
                t tVar6 = this.mTitleBinding;
                if (tVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar6 = null;
                }
                QUIBadgeMosaic qUIBadgeMosaic2 = tVar6.f444916q;
                Intrinsics.checkNotNullExpressionValue(qUIBadgeMosaic2, "mTitleBinding.unreadTv");
                if (qUIBadgeMosaic2.getVisibility() == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    t tVar7 = this.mTitleBinding;
                    if (tVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar7 = null;
                    }
                    tVar7.f444916q.setVisibility(0);
                    AIOUtil aIOUtil = AIOUtil.f194084a;
                    t tVar8 = this.mTitleBinding;
                    if (tVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar8 = null;
                    }
                    QUIBadgeMosaic qUIBadgeMosaic3 = tVar8.f444916q;
                    Intrinsics.checkNotNullExpressionValue(qUIBadgeMosaic3, "mTitleBinding.unreadTv");
                    aIOUtil.H(qUIBadgeMosaic3);
                    if (unreadCount > 0) {
                        a17 = 0;
                    } else {
                        a17 = x.a(8.0f);
                    }
                    layoutParams2.setMarginEnd(a17);
                }
            }
            t tVar9 = this.mTitleBinding;
            if (tVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar9 = null;
            }
            QUIBadgeMosaic qUIBadgeMosaic4 = tVar9.f444916q;
            if (unreadCount > 0) {
                i3 = 0;
            }
            qUIBadgeMosaic4.setVisibility(i3);
            if (unreadCount > 0) {
                a16 = 0;
            } else {
                a16 = x.a(8.0f);
            }
            layoutParams2.setMarginEnd(a16);
        }
        t tVar10 = this.mTitleBinding;
        if (tVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar10 = null;
        }
        tVar10.f444916q.setImportantForAccessibility(2);
        if (unreadCount > 0) {
            str = getMContext().getResources().getString(R.string.yt8, String.valueOf(unreadCount));
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (unreadCount > 0) {\n \u2026\n            \"\"\n        }");
        t tVar11 = this.mTitleBinding;
        if (tVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            tVar2 = tVar11;
        }
        tVar2.f444905f.setContentDescription(HardCodeUtil.qqStr(R.string.yt7) + str);
    }

    private final void j1() {
        TextView textView = new TextView(getMContext());
        textView.setText(R.string.qtl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.setMarginEnd(ViewUtils.dpToPx(8.0f));
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotAIOTitleVB.k1(RobotAIOTitleVB.this, view);
            }
        });
        textView.setTextSize(17.0f);
        textView.setTextColor(getMContext().getResources().getColor(R.color.qui_common_text_nav_secondary));
        t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        tVar.f444911l.addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(RobotAIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.a.f193971d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l1() {
        u uVar = this.mRight3IvBinding;
        t tVar = null;
        if (uVar != null) {
            if (uVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                uVar = null;
            }
            uVar.f444920b.setVisibility(8);
        }
        t tVar2 = this.mTitleBinding;
        if (tVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            tVar = tVar2;
        }
        tVar.f444910k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotAIOTitleVB.m1(view);
            }
        });
        tVar.f444905f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotAIOTitleVB.n1(RobotAIOTitleVB.this, view);
            }
        });
        tVar.f444916q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotAIOTitleVB.o1(RobotAIOTitleVB.this, view);
            }
        });
        int a16 = x.a(5.0f);
        AIOUtil.f194084a.e(tVar.f444905f, a16, a16, a16, a16);
        s1(false, false);
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            B1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(RobotAIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.o.f193988d);
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_return_button_aio_pg");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(RobotAIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.j.f193982d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q1() {
        int i3;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 = ImmersiveUtils.getStatusBarHeight(getMContext());
        } else {
            i3 = 0;
        }
        final int dimension = (int) getMContext().getResources().getDimension(R.dimen.f158287c11);
        t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        final int paddingTop = tVar.f444910k.getPaddingTop();
        ValueAnimator ofInt = ValueAnimator.ofInt(paddingTop, i3);
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RobotAIOTitleVB.r1(RobotAIOTitleVB.this, dimension, paddingTop, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(RobotAIOTitleVB this$0, int i3, int i16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        t tVar = this$0.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        RelativeLayout relativeLayout = tVar.f444910k;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), intValue, relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        this$0.sendIntent(new n.i(i3 + intValue, intValue - i16));
    }

    private final void s1(boolean isSelectMode, boolean isScaleChat) {
        Integer num;
        int a16;
        t tVar = this.mTitleBinding;
        u uVar = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        TextView textView = tVar.f444905f;
        textView.setTextColor(AppCompatResources.getColorStateList(getMContext(), R.color.qui_common_text_nav_secondary));
        if (isSelectMode) {
            textView.setText(getMContext().getText(R.string.f170256ys3));
            textView.setBackground(null);
            textView.setContentDescription(textView.getText());
        } else {
            textView.setText("");
            I1(isScaleChat, isSelectMode);
        }
        t tVar2 = this.mTitleBinding;
        if (tVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar2 = null;
        }
        ViewGroup.LayoutParams layoutParams = tVar2.f444905f.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        boolean z16 = false;
        if (isSelectMode) {
            t tVar3 = this.mTitleBinding;
            if (tVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar3 = null;
            }
            QUIBadgeMosaic qUIBadgeMosaic = tVar3.f444916q;
            t tVar4 = this.mTitleBinding;
            if (tVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar4 = null;
            }
            qUIBadgeMosaic.setTag(Integer.valueOf(tVar4.f444916q.getVisibility()));
            t tVar5 = this.mTitleBinding;
            if (tVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar5 = null;
            }
            tVar5.f444916q.setVisibility(8);
            layoutParams2.setMarginEnd(x.a(8.0f));
            u uVar2 = this.mRight3IvBinding;
            if (uVar2 != null) {
                if (uVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                    uVar2 = null;
                }
                RedDotImageView redDotImageView = uVar2.f444920b;
                u uVar3 = this.mRight3IvBinding;
                if (uVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                } else {
                    uVar = uVar3;
                }
                redDotImageView.setTag(Integer.valueOf(uVar.f444920b.getVisibility()));
                F1(false, "");
                return;
            }
            return;
        }
        t tVar6 = this.mTitleBinding;
        if (tVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar6 = null;
        }
        Object tag = tVar6.f444916q.getTag();
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            t tVar7 = this.mTitleBinding;
            if (tVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar7 = null;
            }
            tVar7.f444916q.setVisibility(intValue);
        }
        t tVar8 = this.mTitleBinding;
        if (tVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar8 = null;
        }
        if (tVar8.f444916q.getVisibility() == 0) {
            a16 = 0;
        } else {
            a16 = x.a(8.0f);
        }
        layoutParams2.setMarginEnd(a16);
        u uVar4 = this.mRight3IvBinding;
        if (uVar4 != null) {
            if (uVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                uVar4 = null;
            }
            if (uVar4.f444920b.getTag() != null) {
                Object j3 = com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_top_feature_entry_left", "");
                Intrinsics.checkNotNull(j3, "null cannot be cast to non-null type kotlin.String");
                String str = (String) j3;
                u uVar5 = this.mRight3IvBinding;
                if (uVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                } else {
                    uVar = uVar5;
                }
                Object tag2 = uVar.f444920b.getTag();
                Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) tag2).intValue() == 0) {
                    z16 = true;
                }
                F1(z16, str);
            }
        }
    }

    private final void v1() {
        u uVar = null;
        if (this.mRight3IvBinding == null) {
            LayoutInflater from = LayoutInflater.from(getMContext());
            t tVar = this.mTitleBinding;
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar = null;
            }
            u g16 = u.g(from, tVar.f444911l, true);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026tleBinding.titleLl, true)");
            this.mRight3IvBinding = g16;
        }
        u uVar2 = this.mRight3IvBinding;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
        } else {
            uVar = uVar2;
        }
        uVar.f444920b.setContentDescription("");
    }

    private final void w1() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.titlebar.h
            @Override // java.lang.Runnable
            public final void run() {
                RobotAIOTitleVB.x1(RobotAIOTitleVB.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(RobotAIOTitleVB this$0) {
        t.a y16;
        t.a F1;
        t.a y17;
        t.a F12;
        t.a F13;
        t.a y18;
        t.a F14;
        t.a y19;
        t.a F15;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            try {
                if (QQTheme.isVasTheme()) {
                    w71.t tVar = this$0.mTitleBinding;
                    if (tVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar = null;
                    }
                    tVar.f444911l.setBackground(this$0.getMContext().getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
                } else {
                    w71.t tVar2 = this$0.mTitleBinding;
                    if (tVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar2 = null;
                    }
                    tVar2.f444911l.setBackgroundColor(this$0.getMContext().getResources().getColor(R.color.qui_common_bg_nav_aio));
                }
                w71.t tVar3 = this$0.mTitleBinding;
                if (tVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar3 = null;
                }
                tVar3.f444911l.invalidate();
                com.tencent.mobileqq.aio.utils.am amVar = com.tencent.mobileqq.aio.utils.am.f194110a;
                w71.t tVar4 = this$0.mTitleBinding;
                if (tVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar4 = null;
                }
                AIOTitleRelativeLayout aIOTitleRelativeLayout = tVar4.f444911l;
                Intrinsics.checkNotNullExpressionValue(aIOTitleRelativeLayout, "mTitleBinding.titleLl");
                Bitmap e16 = amVar.e(aIOTitleRelativeLayout, true);
                w71.t tVar5 = this$0.mTitleBinding;
                if (tVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar5 = null;
                }
                tVar5.f444914o.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                w71.t tVar6 = this$0.mTitleBinding;
                if (tVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar6 = null;
                }
                tVar6.f444916q.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                w71.t tVar7 = this$0.mTitleBinding;
                if (tVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar7 = null;
                }
                tVar7.f444913n.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                CenterVB centerVB = this$0.mCenterVB;
                if (centerVB != null && (F15 = centerVB.F1()) != null) {
                    F15.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                }
                CenterVB centerVB2 = this$0.mCenterVB;
                if (centerVB2 != null && (y19 = centerVB2.y1()) != null) {
                    y19.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                }
                w71.t tVar8 = this$0.mTitleBinding;
                if (tVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar8 = null;
                }
                AIOTitleRelativeLayout aIOTitleRelativeLayout2 = tVar8.f444911l;
                Intrinsics.checkNotNullExpressionValue(aIOTitleRelativeLayout2, "mTitleBinding.titleLl");
                Bitmap e17 = amVar.e(aIOTitleRelativeLayout2, false);
                w71.t tVar9 = this$0.mTitleBinding;
                if (tVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar9 = null;
                }
                tVar9.f444911l.setBackground(null);
                w71.t tVar10 = this$0.mTitleBinding;
                if (tVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar10 = null;
                }
                tVar10.f444911l.invalidate();
                w71.t tVar11 = this$0.mTitleBinding;
                if (tVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar11 = null;
                }
                tVar11.f444914o.setMosaicEffect(null);
                w71.t tVar12 = this$0.mTitleBinding;
                if (tVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar12 = null;
                }
                tVar12.f444916q.setMosaicEffect(null);
                w71.t tVar13 = this$0.mTitleBinding;
                if (tVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar13 = null;
                }
                tVar13.f444913n.setMosaicEffect(null);
                CenterVB centerVB3 = this$0.mCenterVB;
                if (centerVB3 != null && (F14 = centerVB3.F1()) != null) {
                    F14.setMosaicEffect(null);
                }
                CenterVB centerVB4 = this$0.mCenterVB;
                if (centerVB4 != null && (y18 = centerVB4.y1()) != null) {
                    y18.setMosaicEffect(null);
                }
                this$0.sendIntent(new n.k(e16, e17));
                w71.t tVar14 = this$0.mTitleBinding;
                if (tVar14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar14 = null;
                }
                tVar14.f444914o.setMosaicEffect(null);
                w71.t tVar15 = this$0.mTitleBinding;
                if (tVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar15 = null;
                }
                tVar15.f444916q.setMosaicEffect(null);
                w71.t tVar16 = this$0.mTitleBinding;
                if (tVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar16 = null;
                }
                tVar16.f444913n.setMosaicEffect(null);
                CenterVB centerVB5 = this$0.mCenterVB;
                if (centerVB5 != null && (F13 = centerVB5.F1()) != null) {
                    F13.setMosaicEffect(null);
                }
                CenterVB centerVB6 = this$0.mCenterVB;
                if (centerVB6 == null || (y16 = centerVB6.y1()) == null) {
                    return;
                }
            } catch (Exception e18) {
                QLog.e("RobotAIOTitleVB", 1, "LongShot titleBar bitmap exception: " + e18);
                w71.t tVar17 = this$0.mTitleBinding;
                if (tVar17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar17 = null;
                }
                tVar17.f444914o.setMosaicEffect(null);
                w71.t tVar18 = this$0.mTitleBinding;
                if (tVar18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar18 = null;
                }
                tVar18.f444916q.setMosaicEffect(null);
                w71.t tVar19 = this$0.mTitleBinding;
                if (tVar19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar19 = null;
                }
                tVar19.f444913n.setMosaicEffect(null);
                CenterVB centerVB7 = this$0.mCenterVB;
                if (centerVB7 != null && (F1 = centerVB7.F1()) != null) {
                    F1.setMosaicEffect(null);
                }
                CenterVB centerVB8 = this$0.mCenterVB;
                if (centerVB8 == null || (y16 = centerVB8.y1()) == null) {
                    return;
                }
            }
            y16.setMosaicEffect(null);
        } catch (Throwable th5) {
            w71.t tVar20 = this$0.mTitleBinding;
            if (tVar20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar20 = null;
            }
            tVar20.f444914o.setMosaicEffect(null);
            w71.t tVar21 = this$0.mTitleBinding;
            if (tVar21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar21 = null;
            }
            tVar21.f444916q.setMosaicEffect(null);
            w71.t tVar22 = this$0.mTitleBinding;
            if (tVar22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar22 = null;
            }
            tVar22.f444913n.setMosaicEffect(null);
            CenterVB centerVB9 = this$0.mCenterVB;
            if (centerVB9 != null && (F12 = centerVB9.F1()) != null) {
                F12.setMosaicEffect(null);
            }
            CenterVB centerVB10 = this$0.mCenterVB;
            if (centerVB10 != null && (y17 = centerVB10.y1()) != null) {
                y17.setMosaicEffect(null);
            }
            throw th5;
        }
    }

    private final void y1(boolean visiable, String type) {
        u uVar = this.mRight3IvBinding;
        if (uVar == null) {
            return;
        }
        if (visiable) {
            HashMap hashMap = new HashMap();
            hashMap.put("aio_left_business_type", type);
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_top_feature_entry_left", hashMap);
            com.tencent.mobileqq.aio.utils.b.f194119a.c("em_bas_aio_top_feature_entry_left", type);
            return;
        }
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar = null;
        }
        if (uVar.f444920b.getVisibility() == 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("aio_left_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_top_feature_entry_left", ""));
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_top_feature_entry_left", hashMap2);
        }
    }

    private final void z1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_left_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_top_feature_entry_left", ""));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_top_feature_entry_left", hashMap);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        l1();
        sendIntent(n.d.f193974d);
        sendIntent(new n.c(0, 1, null));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends AIOTitleUIState>> getObserverStates() {
        List<Class<? extends AIOTitleUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(AIOTitleUIState.UpdateData.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> mutableListOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        this.mCenterVB = new CenterVB(new Function0<w71.t>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotAIOTitleVB$initializeChildVB$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final w71.t invoke() {
                w71.t tVar;
                tVar = RobotAIOTitleVB.this.mTitleBinding;
                if (tVar != null) {
                    return tVar;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                return null;
            }
        });
        CenterVB centerVB = this.mCenterVB;
        Intrinsics.checkNotNull(centerVB);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new RobotRight1VB(new Function0<RedDotImageView>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotAIOTitleVB$initializeChildVB$list$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RedDotImageView invoke() {
                w71.t tVar;
                tVar = RobotAIOTitleVB.this.mTitleBinding;
                if (tVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar = null;
                }
                RedDotImageView redDotImageView = tVar.f444907h;
                Intrinsics.checkNotNullExpressionValue(redDotImageView, "mTitleBinding.right1Iv");
                return redDotImageView;
            }
        }), new Right2VB(new Function0<RedDotImageView>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotAIOTitleVB$initializeChildVB$list$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RedDotImageView invoke() {
                w71.t tVar;
                tVar = RobotAIOTitleVB.this.mTitleBinding;
                if (tVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar = null;
                }
                RedDotImageView redDotImageView = tVar.f444908i;
                Intrinsics.checkNotNullExpressionValue(redDotImageView, "mTitleBinding.right2Iv");
                return redDotImageView;
            }
        }), centerVB);
        return mutableListOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        w71.t g16 = w71.t.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mTitleBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            g16 = null;
        }
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        y1(false, "");
        super.onDestroy();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<n, AIOTitleUIState> createVM() {
        return new AIOTitleVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOTitleUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOTitleUIState.UpdateData) {
            G1(((AIOTitleUIState.UpdateData) state).a());
            return;
        }
        if (state instanceof AIOTitleUIState.MultiSelectModeChangeState) {
            AIOTitleUIState.MultiSelectModeChangeState multiSelectModeChangeState = (AIOTitleUIState.MultiSelectModeChangeState) state;
            s1(multiSelectModeChangeState.b(), multiSelectModeChangeState.a());
            return;
        }
        if (state instanceof AIOTitleUIState.PushShotTitleBitmap) {
            w1();
            return;
        }
        if (state instanceof AIOTitleUIState.UpdateUnread) {
            AIOTitleUIState.UpdateUnread updateUnread = (AIOTitleUIState.UpdateUnread) state;
            J1(updateUnread.a(), updateUnread.b(), true, updateUnread.c());
            return;
        }
        if (state instanceof AIOTitleUIState.UpdateRight3IvState) {
            D1(((AIOTitleUIState.UpdateRight3IvState) state).a());
            return;
        }
        if (!(state instanceof AIOTitleUIState.UpdateZplanState)) {
            if (state instanceof AIOTitleUIState.AddFinishBtn) {
                j1();
            } else if (state instanceof AIOTitleUIState.ResetAccessibilityFocus) {
                A1();
            } else if (state instanceof AIOTitleUIState.ExpandFullScreenAnim) {
                q1();
            }
        }
    }
}
