package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\u0013\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J*\u0010\u0015\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0016H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010)R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskSearchModePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/text/TextWatcher;", "", "F9", "M9", "L9", "", "keyword", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "Lpz1/c;", "d", "Lpz1/c;", "getViewModel", "()Lpz1/c;", "viewModel", "Lpz1/e;", "e", "Lpz1/e;", "searchViewModel", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", tl.h.F, "Landroid/view/View;", "listContainer", "i", "searchListContainer", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", "mSearchBar", "Landroid/widget/EditText;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/EditText;", "mSearchEditText", "D", "mSearchTipsContainer", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mSearchCloseButton", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mSearchCancel", "<init>", "(Lpz1/c;Lpz1/e;Landroidx/lifecycle/LifecycleOwner;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RiskSearchModePart extends Part implements TextWatcher {

    /* renamed from: C, reason: from kotlin metadata */
    private EditText mSearchEditText;

    /* renamed from: D, reason: from kotlin metadata */
    private View mSearchTipsContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mSearchCloseButton;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mSearchCancel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pz1.c viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pz1.e searchViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View listContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View searchListContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mSearchBar;

    public RiskSearchModePart(@NotNull pz1.c viewModel, @NotNull pz1.e searchViewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(searchViewModel, "searchViewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.searchViewModel = searchViewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void F9() {
        RelativeLayout relativeLayout = this.mSearchBar;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBar");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        EditText editText = this.mSearchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText = null;
        }
        editText.clearFocus();
        EditText editText2 = this.mSearchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText2 = null;
        }
        editText2.addTextChangedListener(this);
        View view = this.mSearchTipsContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchTipsContainer");
            view = null;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean G9;
                G9 = RiskSearchModePart.G9(RiskSearchModePart.this, view2, motionEvent);
                return G9;
            }
        });
        getPartRootView().setFocusableInTouchMode(true);
        ImageView imageView = this.mSearchCloseButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCloseButton");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RiskSearchModePart.H9(RiskSearchModePart.this, view2);
            }
        });
        TextView textView2 = this.mSearchCancel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RiskSearchModePart.I9(RiskSearchModePart.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G9(RiskSearchModePart this$0, View v3, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewModel.q2(true);
        com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g gVar = com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.f234195a;
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.b(gVar, v3, "clck", "em_sgrp_search_box", null, 8, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(RiskSearchModePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mSearchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText = null;
        }
        editText.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(RiskSearchModePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mSearchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText = null;
        }
        editText.setText("");
        this$0.viewModel.q2(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void K9(String keyword) {
        this.searchViewModel.Q1(keyword);
        ImageView imageView = null;
        if (TextUtils.isEmpty(keyword)) {
            ImageView imageView2 = this.mSearchCloseButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchCloseButton");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.mSearchCloseButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCloseButton");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        View view = this.searchListContainer;
        EditText editText = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListContainer");
            view = null;
        }
        view.setVisibility(8);
        TextView textView = this.mSearchCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
            textView = null;
        }
        textView.setVisibility(8);
        EditText editText2 = this.mSearchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText2 = null;
        }
        editText2.setHint((CharSequence) null);
        View view2 = this.mSearchTipsContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchTipsContainer");
            view2 = null;
        }
        view2.setVisibility(0);
        EditText editText3 = this.mSearchEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText3 = null;
        }
        InputMethodUtil.hide(editText3);
        EditText editText4 = this.mSearchEditText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText4 = null;
        }
        editText4.clearFocus();
        EditText editText5 = this.mSearchEditText;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
        } else {
            editText = editText5;
        }
        editText.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        EditText editText = this.mSearchEditText;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText = null;
        }
        if (editText.hasFocus()) {
            TextView textView2 = this.mSearchCancel;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
            } else {
                textView = textView2;
            }
            InputMethodUtil.show(textView);
            return;
        }
        View view = this.searchListContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListContainer");
            view = null;
        }
        view.setVisibility(0);
        View view2 = this.mSearchTipsContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchTipsContainer");
            view2 = null;
        }
        view2.setVisibility(8);
        EditText editText2 = this.mSearchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText2 = null;
        }
        editText2.setVisibility(0);
        EditText editText3 = this.mSearchEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText3 = null;
        }
        editText3.setHint(HardCodeUtil.qqStr(R.string.f155451hj));
        TextView textView3 = this.mSearchCancel;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
            textView3 = null;
        }
        textView3.setVisibility(0);
        EditText editText4 = this.mSearchEditText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText4 = null;
        }
        editText4.setFocusable(true);
        EditText editText5 = this.mSearchEditText;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText5 = null;
        }
        editText5.setFocusableInTouchMode(true);
        EditText editText6 = this.mSearchEditText;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText6 = null;
        }
        editText6.requestFocus();
        EditText editText7 = this.mSearchEditText;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
        } else {
            textView = editText7;
        }
        InputMethodUtil.show(textView);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s16) {
        int i3;
        boolean z16;
        EditText editText = this.mSearchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEditText");
            editText = null;
        }
        String obj = editText.getText().toString();
        int length = obj.length() - 1;
        int i16 = 0;
        boolean z17 = false;
        while (i16 <= length) {
            if (!z17) {
                i3 = i16;
            } else {
                i3 = length;
            }
            if (Intrinsics.compare((int) obj.charAt(i3), 32) <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z17) {
                if (!z16) {
                    z17 = true;
                } else {
                    i16++;
                }
            } else if (!z16) {
                break;
            } else {
                length--;
            }
        }
        K9(obj.subSequence(i16, length + 1).toString());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f75093y1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.risk_list_container)");
        this.listContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f81054d5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.search_list)");
        this.searchListContainer = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.search_box);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.search_box)");
        this.mSearchBar = (RelativeLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.et_search_keyword);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.et_search_keyword)");
        this.mSearchEditText = (EditText) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f110986k0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026tv_search_tips_container)");
        this.mSearchTipsContainer = findViewById5;
        View findViewById6 = rootView.findViewById(R.id.ib_clear_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.ib_clear_text)");
        this.mSearchCloseButton = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.ijd);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.search_cancel)");
        this.mSearchCancel = (TextView) findViewById7;
        ImageView imageView = this.mSearchCloseButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCloseButton");
            imageView = null;
        }
        GuildUIUtils.d(imageView, R.drawable.guild_member_search_box_close, Integer.valueOf(R.color.qui_common_icon_secondary));
        F9();
        MutableLiveData<Boolean> a26 = this.viewModel.a2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskSearchModePart$onInitView$1
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
            public final void invoke2(Boolean isSearchMode) {
                View view;
                View view2;
                Intrinsics.checkNotNullExpressionValue(isSearchMode, "isSearchMode");
                View view3 = null;
                if (isSearchMode.booleanValue()) {
                    RiskSearchModePart.this.M9();
                    view2 = RiskSearchModePart.this.listContainer;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
                    } else {
                        view3 = view2;
                    }
                    view3.setVisibility(8);
                    return;
                }
                RiskSearchModePart.this.L9();
                view = RiskSearchModePart.this.listContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listContainer");
                } else {
                    view3 = view;
                }
                view3.setVisibility(0);
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RiskSearchModePart.J9(Function1.this, obj);
            }
        });
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
    }
}
