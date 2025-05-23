package com.tencent.mobileqq.selectfriend.part;

import android.content.ComponentCallbacks2;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/ForwardFriendTitleBarPart;", "Lcom/tencent/mobileqq/selectfriend/part/a;", "", "initData", "initView", "oa", "ra", "Fa", "Da", "Ea", "na", "qa", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "rightButton", "I", "leftButton", "J", "tvTitle", "Landroid/view/View$OnClickListener;", "K", "Landroid/view/View$OnClickListener;", NodeProps.ON_CLICK, "<init>", "()V", "L", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ForwardFriendTitleBarPart extends a {

    /* renamed from: H, reason: from kotlin metadata */
    private TextView rightButton;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView leftButton;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: K, reason: from kotlin metadata */
    private final View.OnClickListener onClick = new View.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.part.b
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ForwardFriendTitleBarPart.pa(ForwardFriendTitleBarPart.this, view);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da() {
        TextView textView = this.rightButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView3 = this.rightButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView3 = null;
        }
        textView3.setText(HardCodeUtil.qqStr(R.string.mpn));
        TextView textView4 = this.rightButton;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView4 = null;
        }
        textView4.setTextColor(getContext().getResources().getColor(R.color.skin_bar_text));
        TextView textView5 = this.rightButton;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView5 = null;
        }
        textView5.setClickable(true);
        TextView textView6 = this.leftButton;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            textView6 = null;
        }
        textView6.setVisibility(0);
        TextView textView7 = this.leftButton;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            textView7 = null;
        }
        textView7.setBackgroundDrawable(null);
        TextView textView8 = this.leftButton;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            textView8 = null;
        }
        textView8.setText(HardCodeUtil.qqStr(R.string.mpt));
        if (AppSetting.f99565y) {
            TextView textView9 = this.leftButton;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftButton");
                textView9 = null;
            }
            TextView textView10 = this.leftButton;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftButton");
                textView10 = null;
            }
            textView9.setContentDescription(textView10.getText());
            TextView textView11 = this.rightButton;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView11 = null;
            }
            TextView textView12 = this.rightButton;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            } else {
                textView2 = textView12;
            }
            textView11.setContentDescription(textView2.getText());
        }
    }

    private final void Ea() {
        TextView textView = this.leftButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView3 = this.rightButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.rightButton;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        } else {
            textView2 = textView4;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.j6l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa() {
        TextView textView = this.leftButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            textView = null;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.cancel));
        TextView textView3 = this.leftButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            textView3 = null;
        }
        textView3.setBackgroundDrawable(null);
        TextView textView4 = this.rightButton;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView4 = null;
        }
        textView4.setText(HardCodeUtil.qqStr(R.string.f212635o2));
        TextView textView5 = this.rightButton;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView5 = null;
        }
        textView5.setTextColor(getContext().getResources().getColor(R.color.skin_color_ffcccccc));
        TextView textView6 = this.rightButton;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        } else {
            textView2 = textView6;
        }
        textView2.setClickable(false);
    }

    private final void initData() {
        dq2.b E9 = E9();
        if (E9 != null) {
            E9.d2(getMExtraData(), getMFsLayoutData());
        }
    }

    private final void initView() {
        oa();
    }

    private final void na() {
        TextView textView = this.rightButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        Resources resources = getContext().getResources();
        if (resources == null) {
            return;
        }
        layoutParams2.rightMargin = BaseAIOUtils.f(10.0f, resources);
        TextView textView3 = this.rightButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView3 = null;
        }
        textView3.setLayoutParams(layoutParams2);
        TextView textView4 = this.rightButton;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView4 = null;
        }
        textView4.setPadding(BaseAIOUtils.f(7.0f, resources), 0, BaseAIOUtils.f(7.0f, resources), 0);
        if (AppSetting.f99565y) {
            TextView textView5 = this.rightButton;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView5 = null;
            }
            TextView textView6 = this.rightButton;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView6 = null;
            }
            textView5.setContentDescription(textView6.getText());
            TextView textView7 = this.leftButton;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftButton");
                textView7 = null;
            }
            TextView textView8 = this.leftButton;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            } else {
                textView2 = textView8;
            }
            textView7.setContentDescription(textView2.getText());
        }
    }

    private final void oa() {
        getPartRootView().findViewById(R.id.ivTitleBtnLeft).setVisibility(8);
        getPartRootView().findViewById(R.id.ivTitleBtnRightImage).setVisibility(8);
        View findViewById = getPartRootView().findViewById(R.id.ivTitleName);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026qq.qqui.R.id.ivTitleName)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.ivTitleBtnRightText);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(co\u2026R.id.ivTitleBtnRightText)");
        this.rightButton = (TextView) findViewById2;
        View findViewById3 = getPartRootView().findViewById(R.id.ivTitleBtnLeftButton);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(co\u2026.id.ivTitleBtnLeftButton)");
        TextView textView = (TextView) findViewById3;
        this.leftButton = textView;
        TextView textView2 = null;
        if (textView != null) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftButton");
                textView = null;
            }
            textView.setOnClickListener(this.onClick);
        }
        TextView textView3 = this.rightButton;
        if (textView3 != null) {
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            } else {
                textView2 = textView3;
            }
            textView2.setOnClickListener(this.onClick);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if (r3.getMIsSingleStatusInSearch() == true) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void pa(ForwardFriendTitleBarPart this$0, View view) {
        boolean z16;
        dq2.g H9;
        dq2.b E9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (FastClickUtils.isFastDoubleClick("ForwardFriend..TitleBarPart")) {
            return;
        }
        int id5 = view.getId();
        if (id5 != R.id.ivTitleBtnLeftButton) {
            if (id5 == R.id.ivTitleBtnRightText && (E9 = this$0.E9()) != null) {
                E9.a2(this$0.getMApp(), this$0.getMExtraData());
                return;
            }
            return;
        }
        dq2.g H92 = this$0.H9();
        if (H92 != null) {
            z16 = true;
        }
        z16 = false;
        dq2.b E92 = this$0.E9();
        if (E92 != null) {
            E92.Z1(z16);
        }
        if (!z16 || (H9 = this$0.H9()) == null) {
            return;
        }
        H9.N1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        TextView textView = this.rightButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView = null;
        }
        textView.setEllipsize(null);
        TextView textView3 = this.rightButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            textView3 = null;
        }
        textView3.setMaxWidth(Integer.MAX_VALUE);
        LinkedHashMap<String, ResultRecord> U1 = ((dq2.a) getViewModel(dq2.a.class)).U1();
        if (U1.isEmpty()) {
            TextView textView4 = this.rightButton;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView4 = null;
            }
            textView4.setText(HardCodeUtil.qqStr(R.string.f212635o2));
            TextView textView5 = this.rightButton;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView5 = null;
            }
            textView5.setClickable(false);
            TextView textView6 = this.rightButton;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView6 = null;
            }
            textView6.setTextColor(getContext().getResources().getColor(R.color.skin_color_ffcccccc));
        } else {
            TextView textView7 = this.rightButton;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView7 = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f212625o1);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_forwardr_multi_select)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(U1.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView7.setText(format);
            TextView textView8 = this.rightButton;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView8 = null;
            }
            textView8.setClickable(true);
            TextView textView9 = this.rightButton;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView9 = null;
            }
            textView9.setTextColor(getContext().getResources().getColor(R.color.skin_bar_text));
        }
        if (AppSetting.f99565y) {
            TextView textView10 = this.rightButton;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                textView10 = null;
            }
            TextView textView11 = this.rightButton;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButton");
            } else {
                textView2 = textView11;
            }
            textView10.setContentDescription(textView2.getText());
        }
    }

    private final void ra() {
        MutableLiveData<Boolean> U1;
        MutableLiveData<Boolean> W1;
        MutableLiveData<Boolean> Q1;
        MutableLiveData<Integer> N1;
        MutableLiveData<String> R1;
        MutableLiveData<String> O1;
        MutableLiveData<Boolean> P1;
        MutableLiveData<Boolean> L1;
        MutableLiveData<Boolean> T1;
        MutableLiveData<String> X1;
        dq2.b E9 = E9();
        if (E9 != null && (X1 = E9.X1()) != null) {
            ComponentCallbacks2 activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$1
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
                public final void invoke2(String str) {
                    TextView textView;
                    textView = ForwardFriendTitleBarPart.this.tvTitle;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                        textView = null;
                    }
                    textView.setText(str);
                }
            };
            X1.observe((LifecycleOwner) activity, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.sa(Function1.this, obj);
                }
            });
        }
        dq2.b E92 = E9();
        if (E92 != null && (T1 = E92.T1()) != null) {
            ComponentCallbacks2 activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            T1.observe((LifecycleOwner) activity2, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.ua(ForwardFriendTitleBarPart.this, (Boolean) obj);
                }
            });
        }
        dq2.b E93 = E9();
        if (E93 != null && (L1 = E93.L1()) != null) {
            ComponentCallbacks2 activity3 = getActivity();
            Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$3
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
                public final void invoke2(Boolean bool) {
                    ForwardFriendTitleBarPart.this.getActivity().finish();
                }
            };
            L1.observe((LifecycleOwner) activity3, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.va(Function1.this, obj);
                }
            });
        }
        dq2.b E94 = E9();
        if (E94 != null && (P1 = E94.P1()) != null) {
            ComponentCallbacks2 activity4 = getActivity();
            Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$4
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
                public final void invoke2(Boolean aBoolean) {
                    TextView textView;
                    textView = ForwardFriendTitleBarPart.this.leftButton;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("leftButton");
                        textView = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(aBoolean, "aBoolean");
                    textView.setVisibility(aBoolean.booleanValue() ? 0 : 8);
                }
            };
            P1.observe((LifecycleOwner) activity4, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.wa(Function1.this, obj);
                }
            });
        }
        dq2.b E95 = E9();
        if (E95 != null && (O1 = E95.O1()) != null) {
            ComponentCallbacks2 activity5 = getActivity();
            Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$5
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
                public final void invoke2(String str) {
                    TextView textView;
                    textView = ForwardFriendTitleBarPart.this.leftButton;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("leftButton");
                        textView = null;
                    }
                    textView.setText(str);
                }
            };
            O1.observe((LifecycleOwner) activity5, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.xa(Function1.this, obj);
                }
            });
        }
        dq2.b E96 = E9();
        if (E96 != null && (R1 = E96.R1()) != null) {
            ComponentCallbacks2 activity6 = getActivity();
            Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<String, Unit> function15 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$6
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
                public final void invoke2(String str) {
                    TextView textView;
                    textView = ForwardFriendTitleBarPart.this.rightButton;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
                        textView = null;
                    }
                    textView.setText(str);
                }
            };
            R1.observe((LifecycleOwner) activity6, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.za(Function1.this, obj);
                }
            });
        }
        dq2.b E97 = E9();
        if (E97 != null && (N1 = E97.N1()) != null) {
            ComponentCallbacks2 activity7 = getActivity();
            Intrinsics.checkNotNull(activity7, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Integer, Unit> function16 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$7
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer integer) {
                    TextView textView;
                    textView = ForwardFriendTitleBarPart.this.leftButton;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("leftButton");
                        textView = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(integer, "integer");
                    textView.setBackgroundResource(integer.intValue());
                }
            };
            N1.observe((LifecycleOwner) activity7, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.Aa(Function1.this, obj);
                }
            });
        }
        dq2.b E98 = E9();
        if (E98 != null && (Q1 = E98.Q1()) != null) {
            ComponentCallbacks2 activity8 = getActivity();
            Intrinsics.checkNotNull(activity8, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function17 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$8
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
                public final void invoke2(Boolean bool) {
                    ForwardFriendTitleBarPart.this.qa();
                }
            };
            Q1.observe((LifecycleOwner) activity8, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.Ba(Function1.this, obj);
                }
            });
        }
        dq2.b E99 = E9();
        if (E99 != null && (W1 = E99.W1()) != null) {
            ComponentCallbacks2 activity9 = getActivity();
            Intrinsics.checkNotNull(activity9, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function18 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$9
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
                public final void invoke2(Boolean bool) {
                    ForwardFriendTitleBarPart.this.Fa();
                }
            };
            W1.observe((LifecycleOwner) activity9, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendTitleBarPart.Ca(Function1.this, obj);
                }
            });
        }
        dq2.b E910 = E9();
        if (E910 == null || (U1 = E910.U1()) == null) {
            return;
        }
        ComponentCallbacks2 activity10 = getActivity();
        Intrinsics.checkNotNull(activity10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        final Function1<Boolean, Unit> function19 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart$registerDataObserver$10
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
            public final void invoke2(Boolean bool) {
                ForwardFriendTitleBarPart.this.Da();
            }
        };
        U1.observe((LifecycleOwner) activity10, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ForwardFriendTitleBarPart.ta(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(ForwardFriendTitleBarPart this$0, Boolean aBoolean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(aBoolean, "aBoolean");
        if (aBoolean.booleanValue()) {
            this$0.Ea();
        } else {
            this$0.Da();
        }
        this$0.na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "ForwardFriend..TitleBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ra();
        initView();
        initData();
    }
}
