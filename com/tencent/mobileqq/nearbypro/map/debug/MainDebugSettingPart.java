package com.tencent.mobileqq.nearbypro.map.debug;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.part.e;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/debug/MainDebugSettingPart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "", "zoom", "", "M9", "", "value", "", "N9", "O9", "U9", "S9", "R9", "T9", "P9", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MainDebugSettingPart extends e {
    private final boolean M9(float zoom) {
        if (zoom >= 3.0f && zoom <= 20.0f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(String value) {
        try {
            if (Integer.parseInt(value) < 0) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.k(j.d(), "MockAvatarCount", Integer.parseInt(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(1, Integer.valueOf(Integer.parseInt(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockAvatarClick e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(String value) {
        try {
            if (Integer.parseInt(value) < 0) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.k(j.d(), "MockClusterDis", Integer.parseInt(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(2, Integer.valueOf(Integer.parseInt(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockClusterDisClick e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(String value) {
        try {
            if (Integer.parseInt(value) < 0) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.k(j.d(), "MockReqRadius", Integer.parseInt(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(2, Integer.valueOf(Integer.parseInt(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockReqRadiusClick e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(String value) {
        try {
            if (Integer.parseInt(value) < 0) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.k(j.d(), "MockSelfMoveSpeed", Integer.parseInt(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(2, Integer.valueOf(Integer.parseInt(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockSelfMoveClick e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(String value) {
        try {
            if (!M9(Float.parseFloat(value))) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.j(j.d(), "MockZoomCluster", Float.parseFloat(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(2, Float.valueOf(Float.parseFloat(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockZoomClusterClick e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(String value) {
        try {
            if (!M9(Float.parseFloat(value))) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.j(j.d(), "MockZoomCommon", Float.parseFloat(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(2, Float.valueOf(Float.parseFloat(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockZoomCommonClick e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(String value) {
        try {
            if (!M9(Float.parseFloat(value))) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.j(j.d(), "MockZoomLandMode", Float.parseFloat(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(2, Float.valueOf(Float.parseFloat(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockZoomLandModeClick e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(String value) {
        try {
            if (!M9(Integer.parseInt(value))) {
                QQToast.makeText(getContext(), "\u53c2\u6570\u4e0d\u5408\u6cd5", 1).show();
            } else {
                c.a.k(j.d(), "MockZoomMix", Integer.parseInt(value), null, false, 12, null);
                SimpleEventBus.getInstance().dispatchEvent(new DebugItemEvent(new DebugOptions(2, Integer.valueOf(Integer.parseInt(value)))));
            }
        } catch (Exception e16) {
            ga2.a c16 = j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.d(logTag, "onMockZoomMixClick e:" + e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        LinearLayout linearLayout;
        super.onInitView(rootView);
        if (rootView != null) {
            linearLayout = (LinearLayout) rootView.findViewById(R.id.ueu);
        } else {
            linearLayout = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        DebugMockEditView debugMockEditView = new DebugMockEditView(activity);
        debugMockEditView.setTitle("mock\u4eba\u7269\u4e2a\u6570\uff1a");
        debugMockEditView.setEditText(String.valueOf(c.a.d(j.d(), "MockAvatarCount", 0, null, false, 12, null)));
        debugMockEditView.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.N9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView);
        }
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        DebugMockEditView debugMockEditView2 = new DebugMockEditView(activity2);
        debugMockEditView2.setTitle("\u805a\u5408\u8ddd\u79bb\uff08dp\uff09\uff1a");
        debugMockEditView2.setEditText(String.valueOf(c.a.d(j.d(), "MockClusterDis", 60, null, false, 12, null)));
        debugMockEditView2.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.O9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView2);
        }
        TextView textView = new TextView(getActivity());
        textView.setText("\u8d8a\u8fdc\u666fZoom\u8d8a\u5c0f\uff083-20\uff09");
        textView.setTextColor(-16777216);
        textView.setPadding(com.tencent.mobileqq.nearbypro.utils.d.b(10), 0, 0, 0);
        if (linearLayout != null) {
            linearLayout.addView(textView);
        }
        Activity activity3 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity3, "activity");
        DebugMockEditView debugMockEditView3 = new DebugMockEditView(activity3);
        debugMockEditView3.setTitle("\u6700\u5c0f\u8fdc\u666fZoom(\u6574\u6570)\uff1a");
        debugMockEditView3.setEditText(String.valueOf(c.a.d(j.d(), "MockZoomMix", 13, null, false, 12, null)));
        debugMockEditView3.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.U9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView3);
        }
        Activity activity4 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity4, "activity");
        DebugMockEditView debugMockEditView4 = new DebugMockEditView(activity4);
        debugMockEditView4.setTitle("\u521d\u59cb\u8fdb\u5165Zoom(\u6d6e\u70b9\u6570)\uff1a");
        debugMockEditView4.setEditText(String.valueOf(c.a.c(j.d(), "MockZoomCommon", 14.84f, null, false, 12, null)));
        debugMockEditView4.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.S9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView4);
        }
        Activity activity5 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity5, "activity");
        DebugMockEditView debugMockEditView5 = new DebugMockEditView(activity5);
        debugMockEditView5.setTitle("\u5f00\u59cb\u805a\u5408Zoom(\u6d6e\u70b9\u6570)\uff1a");
        debugMockEditView5.setEditText(String.valueOf(c.a.c(j.d(), "MockZoomCluster", 14.85f, null, false, 12, null)));
        debugMockEditView5.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$6$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.R9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView5);
        }
        Activity activity6 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity6, "activity");
        DebugMockEditView debugMockEditView6 = new DebugMockEditView(activity6);
        debugMockEditView6.setTitle("\u5730\u5757\u7f29\u5c0fZoom(\u6d6e\u70b9\u6570)\uff1a");
        debugMockEditView6.setEditText(String.valueOf(c.a.c(j.d(), "MockZoomLandMode", 14.0f, null, false, 12, null)));
        debugMockEditView6.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$7$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.T9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView6);
        }
        Activity activity7 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity7, "activity");
        DebugMockEditView debugMockEditView7 = new DebugMockEditView(activity7);
        debugMockEditView7.setTitle("\u5730\u56fe\u6570\u636e\u8bf7\u6c42\u534a\u5f84(m)\uff1a");
        debugMockEditView7.setEditText(String.valueOf(c.a.d(j.d(), "MockReqRadius", 7000, null, false, 12, null)));
        debugMockEditView7.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$8$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.P9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView7);
        }
        Activity activity8 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity8, "activity");
        DebugMockEditView debugMockEditView8 = new DebugMockEditView(activity8);
        debugMockEditView8.setTitle("\u81ea\u5df1\u79fb\u52a8\u901f\u5ea6(\u516c\u91cc/\u5c0f\u65f6)\uff1a");
        debugMockEditView8.setEditText(String.valueOf(c.a.d(j.d(), "MockSelfMoveSpeed", 0, null, false, 12, null)));
        debugMockEditView8.setSureTextClick(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.debug.MainDebugSettingPart$onInitView$9$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MainDebugSettingPart.this.Q9(it);
            }
        });
        if (linearLayout != null) {
            linearLayout.addView(debugMockEditView8);
        }
    }
}
