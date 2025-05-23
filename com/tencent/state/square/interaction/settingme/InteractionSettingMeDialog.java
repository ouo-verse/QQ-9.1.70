package com.tencent.state.square.interaction.settingme;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.se.b;
import com.tencent.luggage.wxa.se.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountProcessor;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareInteractionSettingMeActionBinding;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.interaction.InteractionSettingOption;
import com.tencent.state.square.interaction.InteractionSettingOptionList;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.SquareImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 D2\u00020\u0001:\u0001DB\u0086\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u001fH\u0002J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\b\u00102\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u00020\u000bH\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\u0010\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u001fH\u0002J\b\u0010;\u001a\u00020\u000bH\u0002J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u0012H\u0002J\b\u0010>\u001a\u00020\u000bH\u0002J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u0012H\u0002J/\u0010A\u001a\u00020\u000b*\u0002002!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u000b0\u0007H\u0002R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R>\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "inputData", "Lcom/tencent/state/square/interaction/InteractionSettingOption;", "settingClickCb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "", "settingDoneCb", "Lkotlin/Function2;", "", "hasChangeText", "pageInfo", "", "", "", "(Landroid/content/Context;Lcom/tencent/state/square/interaction/InteractionSettingOption;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/util/Map;)V", "adapter", "Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeAdapter;", "getAdapter", "()Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareInteractionSettingMeActionBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "currentOption", "isLoading", "", "isPublishing", NodeProps.MIN_HEIGHT, "result", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeItemData;", "Lkotlin/collections/ArrayList;", "avaItemClick", "itemInfo", "blurTextEdit", "dismiss", "focusTextEdit", "needKeyboard", "formatList", "", "list", "getActivity", "Landroid/app/Activity;", "getScreenHeightPx", "getSelectedPosition", "initData", "initListener", "initReportCreated", "initReportDestroy", "initView", "initWindow", "keyboardSetWindow", "flag", "loadData", "reportBtn", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, "upDateInputArea", "updateTextLast", "text", "observeKeyboardChange", "onChange", "isShowing", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionSettingMeDialog extends Dialog {
    private static final int INPUT_MAX_LENGTH = 10;
    private static final String TAG = "InteractionSettingMeDialog";
    private final InteractionSettingMeAdapter adapter;
    private final VasSquareInteractionSettingMeActionBinding binding;
    private final FastClickUtils clickUtils;
    private InteractionSettingOption currentOption;
    private int hasChangeText;
    private boolean isLoading;
    private boolean isPublishing;
    private final int minHeight;
    private final Map<String, Object> pageInfo;
    private final ArrayList<InteractionSettingMeItemData> result;
    private final Function1<InteractionSettingOption, Unit> settingClickCb;
    private final Function2<InteractionSettingOption, Integer, Unit> settingDoneCb;

    /* JADX INFO: Access modifiers changed from: private */
    public final void avaItemClick(InteractionSettingOption itemInfo) {
        this.currentOption = itemInfo;
        upDateInputArea();
        this.settingClickCb.invoke(itemInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void blurTextEdit() {
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager != null) {
            LinearLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            inputMethodManager.hideSoftInputFromWindow(root.getWindowToken(), 0);
        }
        TextView textView = this.binding.vasSquareInteractionLastTextLength;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareInteractionLastTextLength");
        textView.setVisibility(8);
        SquareImageView squareImageView = this.binding.vasSquareInteractionSettingMeClear;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.vasSquareInteractionSettingMeClear");
        squareImageView.setVisibility(8);
        SquareImageView squareImageView2 = this.binding.vasSquareInteractionSettingMeEdit;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.vasSquareInteractionSettingMeEdit");
        squareImageView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Object> formatList(List<InteractionSettingOption> list) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Iterator<T> it = list.iterator();
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final InteractionSettingOption interactionSettingOption = (InteractionSettingOption) next;
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAllInteractiveOptions inputData:");
            InteractionSettingOption interactionSettingOption2 = this.currentOption;
            sb5.append(interactionSettingOption2 != null ? Long.valueOf(interactionSettingOption2.getOptionId()) : null);
            sb5.append("\uff0c 2itemInfo: ");
            sb5.append(interactionSettingOption.getOptionId());
            squareLog.i(TAG, sb5.toString());
            InteractionSettingOption interactionSettingOption3 = this.currentOption;
            if (interactionSettingOption3 == null || interactionSettingOption3.getOptionId() != interactionSettingOption.getOptionId()) {
                z16 = false;
            } else {
                interactionSettingOption3.setDefaultText(interactionSettingOption.getDefaultText());
                interactionSettingOption.setCustomText(interactionSettingOption3.getCustomText());
                booleanRef.element = true;
            }
            this.result.add(new InteractionSettingMeItemData(interactionSettingOption, z16, new Function1<InteractionSettingOption, Unit>() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$formatList$$inlined$forEachIndexed$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InteractionSettingOption interactionSettingOption4) {
                    invoke2(interactionSettingOption4);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InteractionSettingOption it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                    this.avaItemClick(InteractionSettingOption.this);
                }
            }));
            i3 = i16;
        }
        if (!booleanRef.element) {
            this.result.get(0).setSelect(true);
            this.currentOption = list.get(0);
        }
        upDateInputArea();
        reportBtn("imp");
        SquareBaseKt.getSquareLog().i(TAG, "LIST " + this.result);
        return this.result;
    }

    private final Activity getActivity() {
        boolean z16;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        while (true) {
            z16 = context instanceof Activity;
            if (z16 || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "context.baseContext");
        }
        if (z16) {
            return (Activity) context;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getScreenHeightPx() {
        return ViewExtensionsKt.calPx(getContext(), SquareUtil.getScreenHeight$default(SquareUtil.INSTANCE, 0.0f, 1, null));
    }

    private final int getSelectedPosition() {
        int i3 = 0;
        int i16 = 0;
        for (Object obj : this.result) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((InteractionSettingMeItemData) obj).isSelect()) {
                i3 = i16;
            }
            i16 = i17;
        }
        return i3;
    }

    private final void initData() {
        RecyclerView recyclerView = this.binding.vasSquareInteractionSettingMeList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareInteractionSettingMeList");
        recyclerView.setAdapter(this.adapter);
        loadData();
    }

    private final void initListener() {
        this.binding.vasSquareInteractionContentWrap.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareInteractionSettingMeActionBinding vasSquareInteractionSettingMeActionBinding;
                vasSquareInteractionSettingMeActionBinding = InteractionSettingMeDialog.this.binding;
                vasSquareInteractionSettingMeActionBinding.vasSquareInteractionSettingMeInput.clearFocus();
            }
        });
        this.binding.vasSquareInteractionSettingDone.setOnClickListener(new InteractionSettingMeDialog$initListener$2(this));
        this.binding.vasSquareInteractionSettingMeEdit.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InteractionSettingMeDialog.this.focusTextEdit(true);
            }
        });
        this.binding.vasSquareInteractionSettingMeClose.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InteractionSettingMeDialog.this.dismiss();
            }
        });
        this.binding.vasSquareInteractionSettingMeClear.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareInteractionSettingMeActionBinding vasSquareInteractionSettingMeActionBinding;
                vasSquareInteractionSettingMeActionBinding = InteractionSettingMeDialog.this.binding;
                vasSquareInteractionSettingMeActionBinding.vasSquareInteractionSettingMeInput.setText("");
            }
        });
        EditText editText = this.binding.vasSquareInteractionSettingMeInput;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$$inlined$apply$lambda$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s16) {
                InteractionSettingOption interactionSettingOption;
                if (s16 != null) {
                    String obj = s16.toString();
                    if (obj == null) {
                        obj = "";
                    }
                    interactionSettingOption = InteractionSettingMeDialog.this.currentOption;
                    if (interactionSettingOption != null) {
                        interactionSettingOption.setCustomText(obj);
                    }
                    InteractionSettingMeDialog.this.updateTextLast(obj);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s16, int start, int before, int count) {
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$$inlined$apply$lambda$2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                if (z16) {
                    InteractionSettingMeDialog.this.focusTextEdit(false);
                } else {
                    InteractionSettingMeDialog.this.blurTextEdit();
                }
            }
        });
        Activity activity = getActivity();
        if (activity != null) {
            observeKeyboardChange(activity, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$7
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    VasSquareInteractionSettingMeActionBinding vasSquareInteractionSettingMeActionBinding;
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionSettingMeDialog", z16 ? "show" : "hide", null, 4, null);
                    if (z16) {
                        InteractionSettingMeDialog.this.keyboardSetWindow(true);
                        return;
                    }
                    InteractionSettingMeDialog.this.keyboardSetWindow(false);
                    vasSquareInteractionSettingMeActionBinding = InteractionSettingMeDialog.this.binding;
                    vasSquareInteractionSettingMeActionBinding.vasSquareInteractionSettingMeInput.clearFocus();
                }
            });
        }
    }

    private final void initReportCreated() {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        LinearLayout root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        squareReporter.setPageInfo(root, root2, SquareReportConst.PageId.PAGE_ID_HUDONG_SETTING, this.pageInfo);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        Button button = this.binding.vasSquareInteractionSettingDone;
        Intrinsics.checkNotNullExpressionValue(button, "binding.vasSquareInteractionSettingDone");
        squareReporter2.setElementInfo(button, SquareReportConst.ElementId.ELEMENT_ID_HUDONG_SET_COMPLETE_BTN, new LinkedHashMap(), false, false);
    }

    private final void initReportDestroy() {
        reportBtn("imp_end");
    }

    private final void initView() {
        RecyclerView recyclerView = this.binding.vasSquareInteractionSettingMeList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareInteractionSettingMeList");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        this.binding.vasSquareInteractionSettingMeList.addItemDecoration(new InteractionSettingMeItemGridDivider());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void keyboardSetWindow(boolean flag) {
        int i3;
        int i16;
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "screenHeight: " + getScreenHeightPx() + ",minHeight:" + this.minHeight, null, 4, null);
        if (getScreenHeightPx() > this.minHeight) {
            return;
        }
        RecyclerView recyclerView = this.binding.vasSquareInteractionSettingMeList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareInteractionSettingMeList");
        LinearLayout linearLayout = this.binding.vasSquareInteractionContentWrap;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.vasSquareInteractionContentWrap");
        if (flag) {
            i3 = b.CTRL_INDEX;
            i16 = 129;
        } else {
            i3 = i.CTRL_INDEX;
            i16 = 194;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = ViewExtensionsKt.dip(getContext(), i16);
        recyclerView.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        layoutParams2.height = ViewExtensionsKt.dip(getContext(), i3);
        linearLayout.setLayoutParams(layoutParams2);
        recyclerView.scrollToPosition(getSelectedPosition());
    }

    private final void loadData() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        InteractionManager.INSTANCE.getAllInteractiveOptions(new Function3<InteractionSettingOptionList, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(InteractionSettingOptionList interactionSettingOptionList, Integer num, String str) {
                invoke(interactionSettingOptionList, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(InteractionSettingOptionList interactionSettingOptionList, int i3, String msg2) {
                List<? extends Object> formatList;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                InteractionSettingMeDialog.this.isLoading = false;
                if (interactionSettingOptionList != null && i3 == 0) {
                    InteractionSettingMeAdapter adapter = InteractionSettingMeDialog.this.getAdapter();
                    formatList = InteractionSettingMeDialog.this.formatList(interactionSettingOptionList.getOptions());
                    adapter.appendList(formatList);
                } else {
                    if (msg2.length() > 0) {
                        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                        Context context = InteractionSettingMeDialog.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        squareCommon.showToast(context, msg2, 1);
                    }
                    InteractionSettingMeDialog.this.dismiss();
                }
            }
        });
    }

    private final void observeKeyboardChange(Activity activity, final Function1<? super Boolean, Unit> function1) {
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        final View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        final Rect rect = new Rect();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = getScreenHeightPx();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$observeKeyboardChange$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                int screenHeightPx;
                int i3;
                decorView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("height: ");
                screenHeightPx = InteractionSettingMeDialog.this.getScreenHeightPx();
                sb5.append(screenHeightPx);
                sb5.append(",context:");
                i3 = InteractionSettingMeDialog.this.minHeight;
                sb5.append(i3);
                sb5.append(",height:");
                sb5.append(height);
                sb5.append(",lastHeight:");
                sb5.append(intRef.element);
                SquareLogger.DefaultImpls.e$default(squareLog, "InteractionSettingMeDialog", sb5.toString(), null, 4, null);
                int i16 = intRef.element - height;
                if (i16 > 200) {
                    function1.invoke(Boolean.TRUE);
                    intRef.element = height;
                } else if (i16 < -200) {
                    function1.invoke(Boolean.FALSE);
                    intRef.element = height;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportBtn(String reportKey) {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Button button = this.binding.vasSquareInteractionSettingDone;
        Intrinsics.checkNotNullExpressionValue(button, "binding.vasSquareInteractionSettingDone");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_IS_EDIT_TEXT, Integer.valueOf(this.hasChangeText));
        InteractionSettingOption interactionSettingOption = this.currentOption;
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_PROPS_ID, String.valueOf(interactionSettingOption != null ? interactionSettingOption.getOptionId() : 0L));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.reportEvent(reportKey, button, mutableMapOf);
    }

    private final void upDateInputArea() {
        InteractionSettingOption interactionSettingOption = this.currentOption;
        if (interactionSettingOption != null) {
            TextView textView = this.binding.vasSquareInteractionFixedText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareInteractionFixedText");
            textView.setText(interactionSettingOption.getFixedText());
            EditText editText = this.binding.vasSquareInteractionSettingMeInput;
            editText.setText(interactionSettingOption.getCustomText());
            editText.setHint(interactionSettingOption.getDefaultText());
            editText.setSelection(interactionSettingOption.getCustomText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTextLast(String text) {
        TextView textView = this.binding.vasSquareInteractionLastTextLength;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareInteractionLastTextLength");
        textView.setText(text.length() + "/10");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        initReportDestroy();
        super.dismiss();
    }

    public final InteractionSettingMeAdapter getAdapter() {
        return this.adapter;
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null), ViewExtensionsKt.dip(window.getContext(), i.CTRL_INDEX));
            window.setWindowAnimations(R.style.f243260b);
            window.clearFlags(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void focusTextEdit(boolean needKeyboard) {
        if (needKeyboard) {
            EditText editText = this.binding.vasSquareInteractionSettingMeInput;
            editText.requestFocus();
            editText.performClick();
            Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.binding.vasSquareInteractionSettingMeInput, 0);
            }
        }
        TextView textView = this.binding.vasSquareInteractionLastTextLength;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareInteractionLastTextLength");
        textView.setVisibility(0);
        SquareImageView squareImageView = this.binding.vasSquareInteractionSettingMeClear;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.vasSquareInteractionSettingMeClear");
        squareImageView.setVisibility(0);
        SquareImageView squareImageView2 = this.binding.vasSquareInteractionSettingMeEdit;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.vasSquareInteractionSettingMeEdit");
        squareImageView2.setVisibility(8);
        EditText editText2 = this.binding.vasSquareInteractionSettingMeInput;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.vasSquareInteractionSettingMeInput");
        updateTextLast(editText2.getText().toString());
        this.hasChangeText = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InteractionSettingMeDialog(Context context, InteractionSettingOption interactionSettingOption, Function1<? super InteractionSettingOption, Unit> settingClickCb, Function2<? super InteractionSettingOption, ? super Integer, Unit> settingDoneCb, Map<String, Object> pageInfo) {
        super(context, R.style.f243250a);
        InteractionSettingOption interactionSettingOption2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingClickCb, "settingClickCb");
        Intrinsics.checkNotNullParameter(settingDoneCb, "settingDoneCb");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        this.settingClickCb = settingClickCb;
        this.settingDoneCb = settingDoneCb;
        this.pageInfo = pageInfo;
        VasSquareInteractionSettingMeActionBinding inflate = VasSquareInteractionSettingMeActionBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareInteractionSett\u2026utInflater.from(context))");
        this.binding = inflate;
        this.adapter = new InteractionSettingMeAdapter();
        if (interactionSettingOption != null) {
            interactionSettingOption2 = interactionSettingOption.copy((r18 & 1) != 0 ? interactionSettingOption.optionId : 0L, (r18 & 2) != 0 ? interactionSettingOption.optionIcon : null, (r18 & 4) != 0 ? interactionSettingOption.optionText : null, (r18 & 8) != 0 ? interactionSettingOption.fixedText : null, (r18 & 16) != 0 ? interactionSettingOption.customText : null, (r18 & 32) != 0 ? interactionSettingOption.defaultText : null, (r18 & 64) != 0 ? interactionSettingOption.resultMotion : null);
        } else {
            interactionSettingOption2 = null;
        }
        this.currentOption = interactionSettingOption2;
        this.clickUtils = new FastClickUtils(800L);
        this.minHeight = ViewExtensionsKt.dip(context, QVipPrettyAccountProcessor.CMD);
        this.result = new ArrayList<>();
        setContentView(inflate.getRoot());
        initWindow();
        initListener();
        initView();
        initData();
        initReportCreated();
    }
}
