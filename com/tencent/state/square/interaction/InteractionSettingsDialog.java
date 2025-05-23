package com.tencent.state.square.interaction;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareIntimateInfo;
import com.tencent.state.square.databinding.VasSquareFragmentInteractionSettingsBinding;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.SubScene;
import com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog;
import com.tencent.state.square.interaction.widget.InteractionOptionList;
import com.tencent.state.square.interaction.widget.InteractionPlayData;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.utils.SquareSwitchUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSettingsDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "mSquareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "interactionSettings", "Lcom/tencent/state/square/interaction/InteractionSettings;", "(Landroid/content/Context;Lcom/tencent/state/square/data/SquareAvatarItem;Lcom/tencent/state/square/interaction/InteractionSettings;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentInteractionSettingsBinding;", "hasChangeText", "", "interactionList", "", "Lcom/tencent/state/square/interaction/InteractionSettingOption;", "interactionOrder", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "dismiss", "", "getPageInfo", "", "", "", "getPropsToString", "initData", "initReportCreated", "initReportDestroy", "initView", "showOptionSelectDialog", "index", "submit", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionSettingsDialog extends Dialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "InteractionSettingsDial";
    private static final float WINDOW_DIM_AMOUNT = 0.8f;
    private static boolean isOpeningDialog;
    private static InteractionSettingMeDialog optionSelectDialog;
    private final VasSquareFragmentInteractionSettingsBinding binding;
    private int hasChangeText;
    private List<InteractionSettingOption> interactionList;
    private InteractionSelectOrder interactionOrder;
    private final InteractionSettings interactionSettings;
    private final SquareAvatarItem mSquareItem;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J7\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0002\u0010\u0016JS\u0010\u0017\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSettingsDialog$Companion;", "", "()V", "TAG", "", "WINDOW_DIM_AMOUNT", "", "isOpeningDialog", "", "optionSelectDialog", "Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeDialog;", "reportDialogShow", "", "fragment", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "mSquareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "source", "", "pageClickSource", "Lcom/tencent/state/square/detail/EntranceSource;", "(Ljava/lang/ref/WeakReference;Lcom/tencent/state/square/data/SquareAvatarItem;Ljava/lang/Integer;Lcom/tencent/state/square/detail/EntranceSource;)V", "showDialog", "onShow", "Lkotlin/Function0;", "onDismiss", "(Ljava/lang/ref/WeakReference;Lcom/tencent/state/square/data/SquareAvatarItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Lcom/tencent/state/square/detail/EntranceSource;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final void reportDialogShow(WeakReference<Fragment> fragment, SquareAvatarItem mSquareItem, Integer source, EntranceSource pageClickSource) {
            FragmentActivity activity;
            String str;
            Object firstOrNull;
            int i3;
            Resource lookFront;
            Fragment fragment2 = fragment.get();
            if (fragment2 == null || (activity = fragment2.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(activity, "fragment.get()?.activity ?: return");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (pageClickSource != null) {
                if (pageClickSource.getSub() == SubScene.SQUARE_AVATAR) {
                    str = SquareReportConst.Param.EM_STATE_AVATAR;
                } else {
                    str = SquareReportConst.Param.EM_STATE_BUBBLE;
                }
            } else {
                str = "";
            }
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(activity));
            OnlineStatus onlineStatus = mSquareItem.getExtra().getOnlineStatus();
            int i16 = 0;
            linkedHashMap.put(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(onlineStatus != null ? onlineStatus.getTopStatusId() : 0));
            Integer richStatusId = SquareResourceManagerKt.getRichStatusId(mSquareItem);
            linkedHashMap.put(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(richStatusId != null ? richStatusId.intValue() : 0));
            linkedHashMap.put("zplan_other_user_qq", mSquareItem.getUin());
            linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_DOUBLE_CLICK_AVATAR_PG, Integer.valueOf(source != null ? source.intValue() : 0));
            linkedHashMap.put(SquareReportConst.Key.KEY_DETAIL_ENTRANCE_SOURCE, str);
            if (mSquareItem.isDefault()) {
                i3 = 2;
            } else {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mSquareItem.getActions());
                AvatarAction avatarAction = (AvatarAction) firstOrNull;
                i3 = (avatarAction == null || (lookFront = avatarAction.getLookFront()) == null || !lookFront.getIsDefault()) ? 1 : 0;
            }
            linkedHashMap.put(SquareReportConst.Key.KEY_AVATAR_TYPE, Integer.valueOf(i3));
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_FRIEND, Integer.valueOf(mSquareItem.getExtra().getRelationType() == RelationType.FRIEND ? 1 : 0));
            SquareIntimateInfo intimateExtra = mSquareItem.getExtra().getIntimateExtra();
            if (intimateExtra != null && intimateExtra.hasIntimate()) {
                i16 = 1;
            }
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_CLOSE_RELATION, Integer.valueOf(i16));
            SquareBaseKt.getSquareReporter().reportEvent(SquareReportConst.CustomEventId.EVENT_ID_DOUBLE_CLICK_AVATAR_COVER, linkedHashMap);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showDialog(final WeakReference<Fragment> fragment, final SquareAvatarItem mSquareItem, final Function0<Unit> onShow, final Function0<Unit> onDismiss, final Integer source, final EntranceSource pageClickSource) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(mSquareItem, "mSquareItem");
            Intrinsics.checkNotNullParameter(onShow, "onShow");
            Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
            Log.d(InteractionSettingsDialog.TAG, "show interaction settings dialog");
            if (!SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                if (InteractionSettingsDialog.isOpeningDialog) {
                    return;
                }
                InteractionSettingsDialog.isOpeningDialog = true;
                InteractionManager interactionManager = InteractionManager.INSTANCE;
                OnlineStatus onlineStatus = mSquareItem.getExtra().getOnlineStatus();
                int topStatusId = onlineStatus != null ? onlineStatus.getTopStatusId() : 0;
                Integer richStatusId = SquareResourceManagerKt.getRichStatusId(mSquareItem);
                interactionManager.getInteractionSettings(topStatusId, richStatusId != null ? richStatusId.intValue() : 0, new Function3<InteractionSettings, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$Companion$showDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(InteractionSettings interactionSettings, Integer num, String str) {
                        invoke(interactionSettings, num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(InteractionSettings interactionSettings, int i3, String msg2) {
                        Context context;
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        Fragment fragment2 = (Fragment) fragment.get();
                        if (fragment2 == null || (context = fragment2.getContext()) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(context, "fragment.get()?.context \u2026rn@getInteractionSettings");
                        if (interactionSettings != null && i3 == 0) {
                            InteractionSettingsDialog interactionSettingsDialog = new InteractionSettingsDialog(context, mSquareItem, interactionSettings);
                            onShow.invoke();
                            interactionSettingsDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$Companion$showDialog$1.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface dialogInterface) {
                                    onDismiss.invoke();
                                }
                            });
                            interactionSettingsDialog.show();
                            InteractionSettingsDialog.isOpeningDialog = false;
                            InteractionSettingsDialog.INSTANCE.reportDialogShow(fragment, mSquareItem, source, pageClickSource);
                            return;
                        }
                        String string = context.getResources().getString(R.string.xfn);
                        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ion_settings_load_failed)");
                        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                        if (msg2.length() == 0) {
                            msg2 = string;
                        }
                        squareCommon.showToast(context, msg2, 1);
                        InteractionSettingsDialog.isOpeningDialog = false;
                    }
                });
                return;
            }
            reportDialogShow(fragment, mSquareItem, source, pageClickSource);
        }

        public static /* synthetic */ void showDialog$default(Companion companion, WeakReference weakReference, SquareAvatarItem squareAvatarItem, Function0 function0, Function0 function02, Integer num, EntranceSource entranceSource, int i3, Object obj) {
            if ((i3 & 32) != 0) {
                entranceSource = null;
            }
            companion.showDialog(weakReference, squareAvatarItem, function0, function02, num, entranceSource);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionSettingsDialog(Context context, SquareAvatarItem mSquareItem, InteractionSettings interactionSettings) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mSquareItem, "mSquareItem");
        Intrinsics.checkNotNullParameter(interactionSettings, "interactionSettings");
        this.mSquareItem = mSquareItem;
        this.interactionSettings = interactionSettings;
        VasSquareFragmentInteractionSettingsBinding inflate = VasSquareFragmentInteractionSettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentInterac\u2026g.inflate(layoutInflater)");
        this.binding = inflate;
        this.interactionList = new ArrayList();
        this.interactionOrder = InteractionSelectOrder.RANDOM;
        setContentView(inflate.getMContainer());
        initData();
        initView();
        initReportCreated();
    }

    private final Map<String, Object> getPageInfo() {
        SquareAvatarItem squareAvatarItem = this.mSquareItem;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        OnlineStatus onlineStatus = squareAvatarItem.getExtra().getOnlineStatus();
        linkedHashMap.put(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(onlineStatus != null ? onlineStatus.getTopStatusId() : 0));
        Integer richStatusId = SquareResourceManagerKt.getRichStatusId(squareAvatarItem);
        linkedHashMap.put(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(richStatusId != null ? richStatusId.intValue() : 0));
        Resource userResource = squareAvatarItem.getUserResource();
        linkedHashMap.put(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf(userResource != null ? userResource.getActionId() : 0));
        return linkedHashMap;
    }

    public final String getPropsToString() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.interactionList, ",", null, null, 0, null, new Function1<InteractionSettingOption, CharSequence>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$getPropsToString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(InteractionSettingOption interactionSettingOption) {
                return String.valueOf(interactionSettingOption != null ? interactionSettingOption.getOptionId() : 0L);
            }
        }, 30, null);
        return joinToString$default;
    }

    private final void initData() {
        int collectionSizeOrDefault;
        List<InteractionSettingOption> mutableList;
        InteractionSettingsDialog$initData$mapFn$1 interactionSettingsDialog$initData$mapFn$1 = new Function1<InteractionSettingOption, InteractionSettingOption>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initData$mapFn$1
            @Override // kotlin.jvm.functions.Function1
            public final InteractionSettingOption invoke(InteractionSettingOption it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getOptionId() == 0) {
                    return null;
                }
                return it;
            }
        };
        List<InteractionSettingOption> interactionOptions = this.interactionSettings.getInteractionOptions();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(interactionOptions, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = interactionOptions.iterator();
        while (it.hasNext()) {
            arrayList.add(interactionSettingsDialog$initData$mapFn$1.invoke((InteractionSettingsDialog$initData$mapFn$1) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        while (mutableList.size() < 3) {
            mutableList.add(null);
        }
        this.interactionList = mutableList;
        this.interactionOrder = this.interactionSettings.getSelectOrder();
    }

    private final void initReportDestroy() {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Button button = this.binding.submitBtn;
        Intrinsics.checkNotNullExpressionValue(button, "binding.submitBtn");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_IS_EDIT_TEXT, Integer.valueOf(this.hasChangeText));
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ORDER_SHOW, Integer.valueOf(this.interactionOrder != InteractionSelectOrder.SEQUENCE ? 1 : 0));
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_PROPS_ID, getPropsToString());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.reportEvent("imp_end", button, mutableMapOf);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        Button button2 = this.binding.cancelBtn;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.cancelBtn");
        squareReporter2.reportEvent("imp_end", button2, new LinkedHashMap());
        IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
        RelativeLayout mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        squareReporter3.reportEvent("dt_pgout", mContainer, getPageInfo());
        this.binding.optionListView.reportItemDestroy();
    }

    private final void initView() {
        Window window = getWindow();
        if (window != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            window.setLayout(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.8f);
        }
        this.binding.player.setShowText(false);
        this.binding.player.bind(this.mSquareItem);
        FrameLayout frameLayout = this.binding.playerWrapper;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.playerWrapper");
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initView$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding;
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding2;
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding3;
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding4;
                vasSquareFragmentInteractionSettingsBinding = InteractionSettingsDialog.this.binding;
                FrameLayout frameLayout2 = vasSquareFragmentInteractionSettingsBinding.playerWrapper;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.playerWrapper");
                frameLayout2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Context context = InteractionSettingsDialog.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                float f16 = resources.getDisplayMetrics().density;
                vasSquareFragmentInteractionSettingsBinding2 = InteractionSettingsDialog.this.binding;
                Intrinsics.checkNotNullExpressionValue(vasSquareFragmentInteractionSettingsBinding2.playerWrapper, "binding.playerWrapper");
                vasSquareFragmentInteractionSettingsBinding3 = InteractionSettingsDialog.this.binding;
                Intrinsics.checkNotNullExpressionValue(vasSquareFragmentInteractionSettingsBinding3.playerWrapper, "binding.playerWrapper");
                vasSquareFragmentInteractionSettingsBinding4 = InteractionSettingsDialog.this.binding;
                vasSquareFragmentInteractionSettingsBinding4.player.scaleToContainer((int) (r2.getMeasuredWidth() / f16), (int) (r3.getMeasuredHeight() / f16));
            }
        });
        TextView textView = this.binding.statusText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.statusText");
        OnlineStatus onlineStatus = this.mSquareItem.getExtra().getOnlineStatus();
        textView.setText(onlineStatus != null ? onlineStatus.getTitle() : null);
        this.binding.orderSelect.updateOrder(this.interactionOrder, true);
        this.binding.optionListView.updateData(this.interactionList);
        this.binding.optionListView.onDeleteOption(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                List list;
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding;
                List<InteractionSettingOption> list2;
                list = InteractionSettingsDialog.this.interactionList;
                list.set(i3, null);
                vasSquareFragmentInteractionSettingsBinding = InteractionSettingsDialog.this.binding;
                InteractionOptionList interactionOptionList = vasSquareFragmentInteractionSettingsBinding.optionListView;
                list2 = InteractionSettingsDialog.this.interactionList;
                interactionOptionList.updateData(list2);
            }
        });
        this.binding.optionListView.onChangeOption(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                List list;
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding;
                List<InteractionSettingOption> list2;
                if (i3 > 0) {
                    list = InteractionSettingsDialog.this.interactionList;
                    Collections.swap(list, i3 - 1, i3);
                    vasSquareFragmentInteractionSettingsBinding = InteractionSettingsDialog.this.binding;
                    InteractionOptionList interactionOptionList = vasSquareFragmentInteractionSettingsBinding.optionListView;
                    list2 = InteractionSettingsDialog.this.interactionList;
                    interactionOptionList.updateData(list2);
                }
            }
        });
        this.binding.optionListView.onClickOption(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                InteractionSettingsDialog.this.showOptionSelectDialog(i3);
            }
        });
        this.binding.cancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initView$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
                InteractionSettingsDialog.this.dismiss();
            }
        });
        this.binding.orderSelect.setOnOrderChange(new Function1<InteractionSelectOrder, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initView$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InteractionSelectOrder interactionSelectOrder) {
                invoke2(interactionSelectOrder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InteractionSelectOrder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                InteractionSettingsDialog.this.interactionOrder = it;
            }
        });
        this.binding.submitBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$initView$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                int i3;
                InteractionSelectOrder interactionSelectOrder;
                String propsToString;
                Map<String, Object> mutableMapOf;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Pair[] pairArr = new Pair[3];
                i3 = InteractionSettingsDialog.this.hasChangeText;
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_IS_EDIT_TEXT, Integer.valueOf(i3));
                interactionSelectOrder = InteractionSettingsDialog.this.interactionOrder;
                pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ORDER_SHOW, Integer.valueOf(interactionSelectOrder != InteractionSelectOrder.SEQUENCE ? 1 : 0));
                propsToString = InteractionSettingsDialog.this.getPropsToString();
                pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_PROPS_ID, propsToString);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                squareReporter.reportEvent("clck", it, mutableMapOf);
                InteractionSettingsDialog.this.submit();
            }
        });
    }

    public final void showOptionSelectDialog(final int index) {
        if (optionSelectDialog != null) {
            return;
        }
        InteractionSettingOption interactionSettingOption = this.interactionList.get(index);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        InteractionSettingMeDialog interactionSettingMeDialog = new InteractionSettingMeDialog(context, interactionSettingOption, new Function1<InteractionSettingOption, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$showOptionSelectDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InteractionSettingOption interactionSettingOption2) {
                invoke2(interactionSettingOption2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InteractionSettingOption selected) {
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding;
                Intrinsics.checkNotNullParameter(selected, "selected");
                vasSquareFragmentInteractionSettingsBinding = InteractionSettingsDialog.this.binding;
                vasSquareFragmentInteractionSettingsBinding.player.play(new InteractionPlayData(selected.getOptionId(), selected.getResultMotion(), selected.getFixedText() + selected.getCustomText()), new Function0<Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$showOptionSelectDialog$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
            }
        }, new Function2<InteractionSettingOption, Integer, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$showOptionSelectDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(InteractionSettingOption interactionSettingOption2, Integer num) {
                invoke(interactionSettingOption2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(InteractionSettingOption data, int i3) {
                List list;
                InteractionSettingOption copy;
                VasSquareFragmentInteractionSettingsBinding vasSquareFragmentInteractionSettingsBinding;
                List<InteractionSettingOption> list2;
                Intrinsics.checkNotNullParameter(data, "data");
                list = InteractionSettingsDialog.this.interactionList;
                int i16 = index;
                copy = data.copy((r18 & 1) != 0 ? data.optionId : 0L, (r18 & 2) != 0 ? data.optionIcon : null, (r18 & 4) != 0 ? data.optionText : null, (r18 & 8) != 0 ? data.fixedText : null, (r18 & 16) != 0 ? data.customText : null, (r18 & 32) != 0 ? data.defaultText : null, (r18 & 64) != 0 ? data.resultMotion : null);
                list.set(i16, copy);
                vasSquareFragmentInteractionSettingsBinding = InteractionSettingsDialog.this.binding;
                InteractionOptionList interactionOptionList = vasSquareFragmentInteractionSettingsBinding.optionListView;
                list2 = InteractionSettingsDialog.this.interactionList;
                interactionOptionList.updateData(list2);
                InteractionSettingsDialog.this.hasChangeText = i3;
            }
        }, getPageInfo());
        optionSelectDialog = interactionSettingMeDialog;
        interactionSettingMeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$showOptionSelectDialog$3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                InteractionSettingsDialog.optionSelectDialog = null;
            }
        });
        InteractionSettingMeDialog interactionSettingMeDialog2 = optionSelectDialog;
        if (interactionSettingMeDialog2 != null) {
            interactionSettingMeDialog2.show();
        }
    }

    public final void submit() {
        int collectionSizeOrDefault;
        InteractionSettingsDialog$submit$mapFunc$1 interactionSettingsDialog$submit$mapFunc$1 = new Function1<InteractionSettingOption, InteractionSettingOption>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$submit$mapFunc$1
            @Override // kotlin.jvm.functions.Function1
            public final InteractionSettingOption invoke(InteractionSettingOption interactionSettingOption) {
                return interactionSettingOption == null ? new InteractionSettingOption() : interactionSettingOption;
            }
        };
        InteractionManager interactionManager = InteractionManager.INSTANCE;
        OnlineStatus onlineStatus = this.mSquareItem.getExtra().getOnlineStatus();
        int topStatusId = onlineStatus != null ? onlineStatus.getTopStatusId() : 0;
        Integer richStatusId = SquareResourceManagerKt.getRichStatusId(this.mSquareItem);
        int intValue = richStatusId != null ? richStatusId.intValue() : 0;
        InteractionSelectOrder interactionSelectOrder = this.interactionOrder;
        List<InteractionSettingOption> list = this.interactionList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(interactionSettingsDialog$submit$mapFunc$1.invoke((InteractionSettingsDialog$submit$mapFunc$1) it.next()));
        }
        interactionManager.saveInteractionSettings(topStatusId, intValue, new InteractionSettings(interactionSelectOrder, arrayList), new Function2<Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionSettingsDialog$submit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (i3 != 0) {
                    Context context = InteractionSettingsDialog.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    String string = context.getResources().getString(R.string.xft);
                    Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ion_settings_save_failed)");
                    ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                    Context context2 = InteractionSettingsDialog.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    if (!(msg2.length() == 0)) {
                        msg2 = string;
                    }
                    squareCommon.showToast(context2, msg2, 1);
                    return;
                }
                ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
                Context context3 = InteractionSettingsDialog.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                Context context4 = InteractionSettingsDialog.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                squareCommon2.showToast(context3, context4.getResources().getString(R.string.xfu), 2);
                InteractionSettingsDialog.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        initReportDestroy();
        super.dismiss();
        this.binding.player.dispose();
    }

    private final void initReportCreated() {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        RelativeLayout mContainer2 = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.root");
        squareReporter.setPageInfo(mContainer, mContainer2, SquareReportConst.PageId.PAGE_ID_HUDONG_SETTING, getPageInfo());
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout mContainer3 = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer3, "binding.root");
        squareReporter2.reportEvent("dt_pgin", mContainer3, getPageInfo());
        IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
        Button button = this.binding.cancelBtn;
        Intrinsics.checkNotNullExpressionValue(button, "binding.cancelBtn");
        squareReporter3.setElementInfo(button, SquareReportConst.ElementId.ELEMENT_ID_HUDONG_SET_CANCEL_BTN, new LinkedHashMap(), false, false);
        IReporter squareReporter4 = SquareBaseKt.getSquareReporter();
        Button button2 = this.binding.submitBtn;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.submitBtn");
        squareReporter4.setElementInfo(button2, SquareReportConst.ElementId.ELEMENT_ID_HUDONG_SET_CONFIRM_BTN, new LinkedHashMap(), false, false);
        IReporter squareReporter5 = SquareBaseKt.getSquareReporter();
        Button button3 = this.binding.submitBtn;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.submitBtn");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_IS_EDIT_TEXT, Integer.valueOf(this.hasChangeText));
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ORDER_SHOW, Integer.valueOf(this.interactionOrder != InteractionSelectOrder.SEQUENCE ? 1 : 0));
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_PROPS_ID, getPropsToString());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter5.reportEvent("imp", button3, mutableMapOf);
        IReporter squareReporter6 = SquareBaseKt.getSquareReporter();
        Button button4 = this.binding.cancelBtn;
        Intrinsics.checkNotNullExpressionValue(button4, "binding.cancelBtn");
        squareReporter6.reportEvent("imp", button4, new LinkedHashMap());
    }
}
