package com.tencent.state.square.interaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareIntimateInfo;
import com.tencent.state.square.databinding.VasSquareFragmentInteractionActionBinding;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.SubScene;
import com.tencent.state.square.flower.AddFlowerReason;
import com.tencent.state.square.flower.FlowerManager;
import com.tencent.state.square.interaction.InteractionActionDialog;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.utils.SquareSwitchUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0003J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionActionDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "mSquareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "currentOptions", "", "Lcom/tencent/state/square/interaction/InteractionOption;", "selectOrder", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "(Landroid/content/Context;Lcom/tencent/state/square/data/SquareAvatarItem;Ljava/util/List;Lcom/tencent/state/square/interaction/InteractionSelectOrder;)V", "avatarGestureDetector", "Landroid/view/GestureDetector;", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentInteractionActionBinding;", "isSelect", "", "dismiss", "", "doubleClick", "getActivity", "Landroidx/fragment/app/FragmentActivity;", "initData", "initView", "initWindow", "playOption", "interactionOption", "selectOptionAndPlay", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionActionDialog extends Dialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long INTERACTION_TRIGGER_GAP_MS = 500;
    private static final String TAG = "InteractionActionDialog";
    private static boolean isLoadingInteraction;
    private final GestureDetector avatarGestureDetector;
    private final VasSquareFragmentInteractionActionBinding binding;
    private final List<InteractionOption> currentOptions;
    private boolean isSelect;
    private final SquareAvatarItem mSquareItem;
    private final InteractionSelectOrder selectOrder;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ7\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002\u00a2\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J[\u0010\u001e\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionActionDialog$Companion;", "", "()V", "INTERACTION_TRIGGER_GAP_MS", "", "TAG", "", "isLoadingInteraction", "", "interactionNew", "", "interactionData", "Lcom/tencent/state/square/interaction/InteractionManager$InteractData;", "reportDialogShow", "fragment", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "mSquareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "source", "", "pageClickSource", "Lcom/tencent/state/square/detail/EntranceSource;", "(Ljava/lang/ref/WeakReference;Lcom/tencent/state/square/data/SquareAvatarItem;Ljava/lang/Integer;Lcom/tencent/state/square/detail/EntranceSource;)V", "selectOptionAndPlay", "currentOptions", "", "Lcom/tencent/state/square/interaction/InteractionOption;", "selectOrder", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "showActionDialog", "needToastEmpty", "onShow", "Lkotlin/Function0;", "onDismiss", "(Ljava/lang/ref/WeakReference;Lcom/tencent/state/square/data/SquareAvatarItem;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Lcom/tencent/state/square/detail/EntranceSource;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InteractionSelectOrder.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[InteractionSelectOrder.RANDOM.ordinal()] = 1;
                iArr[InteractionSelectOrder.SEQUENCE.ordinal()] = 2;
            }
        }

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
            if (mSquareItem.isDefault()) {
                i3 = 2;
            } else {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mSquareItem.getActions());
                AvatarAction avatarAction = (AvatarAction) firstOrNull;
                i3 = (avatarAction == null || (lookFront = avatarAction.getLookFront()) == null || !lookFront.getIsDefault()) ? 1 : 0;
            }
            linkedHashMap.put(SquareReportConst.Key.KEY_AVATAR_TYPE, Integer.valueOf(i3));
            linkedHashMap.put(SquareReportConst.Key.KEY_DETAIL_ENTRANCE_SOURCE, str);
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_FRIEND, Integer.valueOf(mSquareItem.getExtra().getRelationType() == RelationType.FRIEND ? 1 : 0));
            SquareIntimateInfo intimateExtra = mSquareItem.getExtra().getIntimateExtra();
            if (intimateExtra != null && intimateExtra.hasIntimate()) {
                i16 = 1;
            }
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_CLOSE_RELATION, Integer.valueOf(i16));
            SquareBase.INSTANCE.getConfig().getReporter().reportEvent(SquareReportConst.CustomEventId.EVENT_ID_DOUBLE_CLICK_AVATAR_COVER, linkedHashMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void selectOptionAndPlay(List<InteractionOption> currentOptions, InteractionSelectOrder selectOrder, SquareAvatarItem mSquareItem) {
            int nextInt;
            List<InteractionOption> list;
            Long longOrNull;
            if (currentOptions.isEmpty()) {
                return;
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[selectOrder.ordinal()];
            if (i3 == 1) {
                nextInt = Random.INSTANCE.nextInt(currentOptions.size());
            } else if (i3 == 2) {
                int decodeInt$default = IMMKV.DefaultImpls.decodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Interaction.INTERACTION_OPTION_SELECT_SEQUENCE_KEY_PREFIX, 0, mSquareItem.getUin(), false, 8, null);
                nextInt = decodeInt$default % currentOptions.size();
                IMMKV.DefaultImpls.encodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Interaction.INTERACTION_OPTION_SELECT_SEQUENCE_KEY_PREFIX, decodeInt$default + 1, mSquareItem.getUin(), false, 8, null);
            } else {
                list = currentOptions;
                nextInt = 0;
                InteractionOption interactionOption = list.get(nextInt);
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(mSquareItem.getUin());
                final long longValue = longOrNull == null ? longOrNull.longValue() : 0L;
                FlowerManager.addFlower$default(FlowerManager.INSTANCE, String.valueOf(longValue), AddFlowerReason.Interact, 0, 4, null);
                OnlineStatus onlineStatus = mSquareItem.getExtra().getOnlineStatus();
                int topStatusId = onlineStatus == null ? onlineStatus.getTopStatusId() : 0;
                Integer richStatusId = SquareResourceManagerKt.getRichStatusId(mSquareItem);
                InteractionManager.INSTANCE.interact(new InteractionManager.InteractData(longValue, topStatusId, richStatusId == null ? richStatusId.intValue() : 0, Long.valueOf(interactionOption.getOptionId()), interactionOption, 0, 0, new long[]{longValue}, new Function3<InteractionResult, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$Companion$selectOptionAndPlay$reqData$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(InteractionResult interactionResult, Integer num, String str) {
                        invoke(interactionResult, num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(InteractionResult interactionResult, int i16, String str) {
                        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
                        FlowerManager.INSTANCE.syncFlowerInfo(String.valueOf(longValue));
                    }
                }));
            }
            list = currentOptions;
            InteractionOption interactionOption2 = list.get(nextInt);
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(mSquareItem.getUin());
            final long longValue2 = longOrNull == null ? longOrNull.longValue() : 0L;
            FlowerManager.addFlower$default(FlowerManager.INSTANCE, String.valueOf(longValue2), AddFlowerReason.Interact, 0, 4, null);
            OnlineStatus onlineStatus2 = mSquareItem.getExtra().getOnlineStatus();
            if (onlineStatus2 == null) {
            }
            Integer richStatusId2 = SquareResourceManagerKt.getRichStatusId(mSquareItem);
            InteractionManager.INSTANCE.interact(new InteractionManager.InteractData(longValue2, topStatusId, richStatusId2 == null ? richStatusId2.intValue() : 0, Long.valueOf(interactionOption2.getOptionId()), interactionOption2, 0, 0, new long[]{longValue2}, new Function3<InteractionResult, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$Companion$selectOptionAndPlay$reqData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(InteractionResult interactionResult, Integer num, String str) {
                    invoke(interactionResult, num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(InteractionResult interactionResult, int i16, String str) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
                    FlowerManager.INSTANCE.syncFlowerInfo(String.valueOf(longValue2));
                }
            }));
        }

        public final void interactionNew(final InteractionManager.InteractData interactionData) {
            Intrinsics.checkNotNullParameter(interactionData, "interactionData");
            if (InteractionActionDialog.isLoadingInteraction) {
                return;
            }
            InteractionActionDialog.isLoadingInteraction = true;
            FlowerManager.addFlower$default(FlowerManager.INSTANCE, String.valueOf(interactionData.getInteractedUin()), AddFlowerReason.Interact, 0, 4, null);
            InteractionManager.INSTANCE.getInteractionOptions(interactionData.getInteractedUin(), interactionData.getTargetStatus(), interactionData.getTargetRichStatus(), new Function3<InteractionOptionsInfo, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$Companion$interactionNew$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(InteractionOptionsInfo interactionOptionsInfo, Integer num, String str) {
                    invoke(interactionOptionsInfo, num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(InteractionOptionsInfo interactionOptionsInfo, int i3, String str) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
                    InteractionActionDialog.isLoadingInteraction = false;
                    if (interactionOptionsInfo != null && i3 == 0 && !interactionOptionsInfo.getInteractionOptions().isEmpty()) {
                        InteractionOption interactionOption = interactionOptionsInfo.getInteractionOptions().get(Random.INSTANCE.nextInt(interactionOptionsInfo.getInteractionOptions().size()));
                        InteractionManager.InteractData.this.setOptionId(Long.valueOf(interactionOption.getOptionId()));
                        InteractionManager.InteractData.this.setOptionTmp(interactionOption);
                        InteractionManager.InteractData.this.setCallback(new Function3<InteractionResult, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$Companion$interactionNew$1.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(InteractionResult interactionResult, Integer num, String str2) {
                                invoke(interactionResult, num.intValue(), str2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(InteractionResult interactionResult, int i16, String str2) {
                                Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 2>");
                                FlowerManager.INSTANCE.syncFlowerInfo(String.valueOf(InteractionManager.InteractData.this.getInteractedUin()));
                            }
                        });
                        InteractionManager.INSTANCE.interact(InteractionManager.InteractData.this);
                        return;
                    }
                    FlowerManager.INSTANCE.syncFlowerInfo(String.valueOf(InteractionManager.InteractData.this.getInteractedUin()));
                }
            });
        }

        public final void showActionDialog(final WeakReference<Fragment> fragment, final SquareAvatarItem mSquareItem, final boolean needToastEmpty, final Function0<Unit> onShow, final Function0<Unit> onDismiss, final Integer source, final EntranceSource pageClickSource) {
            Long longOrNull;
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(mSquareItem, "mSquareItem");
            Intrinsics.checkNotNullParameter(onShow, "onShow");
            Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
            if (InteractionActionDialog.isLoadingInteraction) {
                return;
            }
            InteractionActionDialog.isLoadingInteraction = true;
            InteractionManager interactionManager = InteractionManager.INSTANCE;
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(mSquareItem.getUin());
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            OnlineStatus onlineStatus = mSquareItem.getExtra().getOnlineStatus();
            int topStatusId = onlineStatus != null ? onlineStatus.getTopStatusId() : 0;
            Integer richStatusId = SquareResourceManagerKt.getRichStatusId(mSquareItem);
            interactionManager.getInteractionOptions(longValue, topStatusId, richStatusId != null ? richStatusId.intValue() : 0, new Function3<InteractionOptionsInfo, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$Companion$showActionDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(InteractionOptionsInfo interactionOptionsInfo, Integer num, String str) {
                    invoke(interactionOptionsInfo, num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(InteractionOptionsInfo interactionOptionsInfo, int i3, String msg2) {
                    Context context;
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    InteractionActionDialog.isLoadingInteraction = false;
                    Fragment fragment2 = (Fragment) fragment.get();
                    if (fragment2 == null || (context = fragment2.getContext()) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(context, "fragment.get()?.context \u2026urn@getInteractionOptions");
                    if (interactionOptionsInfo != null && i3 == 0) {
                        if (interactionOptionsInfo.getInteractionOptions().isEmpty()) {
                            if (needToastEmpty) {
                                SquareBaseKt.getSquareCommon().showToast(context, context.getString(R.string.xfc), 0);
                                return;
                            }
                            return;
                        } else if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                            InteractionActionDialog.Companion companion = InteractionActionDialog.INSTANCE;
                            companion.selectOptionAndPlay(interactionOptionsInfo.getInteractionOptions(), interactionOptionsInfo.getSelectOrder(), mSquareItem);
                            companion.reportDialogShow(fragment, mSquareItem, source, pageClickSource);
                            return;
                        } else {
                            InteractionActionDialog interactionActionDialog = new InteractionActionDialog(context, mSquareItem, interactionOptionsInfo.getInteractionOptions(), interactionOptionsInfo.getSelectOrder());
                            onShow.invoke();
                            interactionActionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$Companion$showActionDialog$1.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface dialogInterface) {
                                    onDismiss.invoke();
                                }
                            });
                            InteractionActionDialog.INSTANCE.reportDialogShow(fragment, mSquareItem, source, pageClickSource);
                            return;
                        }
                    }
                    if (msg2.length() > 0) {
                        SquareBaseKt.getSquareCommon().showToast(context, msg2, 1);
                    }
                }
            });
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void showActionDialog$default(Companion companion, WeakReference weakReference, SquareAvatarItem squareAvatarItem, boolean z16, Function0 function0, Function0 function02, Integer num, EntranceSource entranceSource, int i3, Object obj) {
            companion.showActionDialog(weakReference, squareAvatarItem, z16, function0, function02, num, (i3 & 64) != 0 ? null : entranceSource);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InteractionSelectOrder.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[InteractionSelectOrder.RANDOM.ordinal()] = 1;
            iArr[InteractionSelectOrder.SEQUENCE.ordinal()] = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionActionDialog(Context context, SquareAvatarItem mSquareItem, List<InteractionOption> currentOptions, InteractionSelectOrder selectOrder) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mSquareItem, "mSquareItem");
        Intrinsics.checkNotNullParameter(currentOptions, "currentOptions");
        Intrinsics.checkNotNullParameter(selectOrder, "selectOrder");
        this.mSquareItem = mSquareItem;
        this.currentOptions = currentOptions;
        this.selectOrder = selectOrder;
        VasSquareFragmentInteractionActionBinding inflate = VasSquareFragmentInteractionActionBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentInterac\u2026g.inflate(layoutInflater)");
        this.binding = inflate;
        this.avatarGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$avatarGestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e16) {
                InteractionActionDialog.this.doubleClick();
                return super.onDoubleTap(e16);
            }
        });
        setContentView(inflate.getMContainer());
        initWindow();
        initView();
        initData();
    }

    public final void doubleClick() {
        selectOptionAndPlay();
    }

    public final FragmentActivity getActivity() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "context.baseContext");
        }
        if (!(context instanceof FragmentActivity)) {
            context = null;
        }
        return (FragmentActivity) context;
    }

    private final void initData() {
        selectOptionAndPlay();
    }

    private final void initView() {
        this.binding.getMContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$initView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z16;
                z16 = InteractionActionDialog.this.isSelect;
                if (z16) {
                    return;
                }
                InteractionActionDialog.this.dismiss();
            }
        });
        ((FrameLayout) this.binding.player.findViewById(R.id.f163426q23)).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$initView$2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                GestureDetector gestureDetector;
                gestureDetector = InteractionActionDialog.this.avatarGestureDetector;
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
        this.binding.player.bind(this.mSquareItem);
    }

    private final void playOption(InteractionOption interactionOption) {
        Long longOrNull;
        if (this.isSelect) {
            return;
        }
        this.isSelect = true;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.mSquareItem.getUin());
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        FlowerManager.addFlower$default(FlowerManager.INSTANCE, String.valueOf(longValue), AddFlowerReason.Interact, 0, 4, null);
        OnlineStatus onlineStatus = this.mSquareItem.getExtra().getOnlineStatus();
        int topStatusId = onlineStatus != null ? onlineStatus.getTopStatusId() : 0;
        Integer richStatusId = SquareResourceManagerKt.getRichStatusId(this.mSquareItem);
        InteractionManager.INSTANCE.interact(new InteractionManager.InteractData(longValue, topStatusId, richStatusId != null ? richStatusId.intValue() : 0, Long.valueOf(interactionOption.getOptionId()), interactionOption, 0, 0, new long[]{longValue}, new InteractionActionDialog$playOption$reqData$2(this, longValue, interactionOption)));
    }

    private final void selectOptionAndPlay() {
        int nextInt;
        if (this.currentOptions.isEmpty()) {
            return;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.selectOrder.ordinal()];
        if (i3 == 1) {
            nextInt = Random.INSTANCE.nextInt(this.currentOptions.size());
        } else if (i3 != 2) {
            nextInt = 0;
        } else {
            int decodeInt$default = IMMKV.DefaultImpls.decodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Interaction.INTERACTION_OPTION_SELECT_SEQUENCE_KEY_PREFIX, 0, this.mSquareItem.getUin(), false, 8, null);
            int size = decodeInt$default % this.currentOptions.size();
            IMMKV.DefaultImpls.encodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Interaction.INTERACTION_OPTION_SELECT_SEQUENCE_KEY_PREFIX, decodeInt$default + 1, this.mSquareItem.getUin(), false, 8, null);
            nextInt = size;
        }
        playOption(this.currentOptions.get(nextInt));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.binding.player.dispose();
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            window.setLayout(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null));
        }
    }
}
