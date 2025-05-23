package com.tencent.state.square.interaction;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareFragmentInteractionActionBinding;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.flower.FlowerManager;
import com.tencent.state.square.interaction.widget.InteractionPlayData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "result", "Lcom/tencent/state/square/interaction/InteractionResult;", "code", "", "msg", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionActionDialog$playOption$reqData$2 extends Lambda implements Function3<InteractionResult, Integer, String, Unit> {
    final /* synthetic */ InteractionOption $interactionOption;
    final /* synthetic */ long $uin;
    final /* synthetic */ InteractionActionDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.square.interaction.InteractionActionDialog$playOption$reqData$2$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
        /* renamed from: com.tencent.state.square.interaction.InteractionActionDialog$playOption$reqData$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes38.dex */
        public static final class RunnableC98601 implements Runnable {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.state.square.interaction.InteractionActionDialog$playOption$reqData$2$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes38.dex */
            public static final class RunnableC98611 implements Runnable {
                RunnableC98611() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VasSquareFragmentInteractionActionBinding vasSquareFragmentInteractionActionBinding;
                    vasSquareFragmentInteractionActionBinding = InteractionActionDialog$playOption$reqData$2.this.this$0.binding;
                    vasSquareFragmentInteractionActionBinding.player.play(new InteractionPlayData(InteractionActionDialog$playOption$reqData$2.this.$interactionOption.getOptionId(), InteractionActionDialog$playOption$reqData$2.this.$interactionOption.getResultMotion(), InteractionActionDialog$playOption$reqData$2.this.$interactionOption.getResultTextTpl()), new Function0<Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog.playOption.reqData.2.1.1.1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog.playOption.reqData.2.1.1.1.1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    InteractionActionDialog$playOption$reqData$2.this.this$0.isSelect = false;
                                    InteractionActionDialog$playOption$reqData$2.this.this$0.dismiss();
                                }
                            });
                        }
                    });
                    Square.INSTANCE.getConfig().getCommonUtils().phoneVibrate(1, 100L);
                }
            }

            RunnableC98601() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FragmentActivity activity;
                DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
                activity = InteractionActionDialog$playOption$reqData$2.this.this$0.getActivity();
                if (detailFragmentLauncher.isValidActivity(activity)) {
                    InteractionActionDialog$playOption$reqData$2.this.this$0.show();
                    ThreadManagerV2.getUIHandlerV2().post(new RunnableC98611());
                }
            }
        }

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ThreadManagerV2.getUIHandlerV2().post(new RunnableC98601());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionActionDialog$playOption$reqData$2(InteractionActionDialog interactionActionDialog, long j3, InteractionOption interactionOption) {
        super(3);
        this.this$0 = interactionActionDialog;
        this.$uin = j3;
        this.$interactionOption = interactionOption;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(InteractionResult interactionResult, Integer num, String str) {
        invoke(interactionResult, num.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(InteractionResult interactionResult, int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        FlowerManager.INSTANCE.syncFlowerInfo(String.valueOf(this.$uin));
        if (interactionResult != null && i3 == 0) {
            InteractionManager.INSTANCE.loadPagResource(this.$interactionOption.getOptionId(), this.$interactionOption.getResultMotion(), new AnonymousClass1(), new Function0<Unit>() { // from class: com.tencent.state.square.interaction.InteractionActionDialog$playOption$reqData$2.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.state.square.interaction.InteractionActionDialog.playOption.reqData.2.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            InteractionActionDialog$playOption$reqData$2.this.this$0.dismiss();
                            Log.w("InteractionActionDialog", "load interaction resource failed " + InteractionActionDialog$playOption$reqData$2.this.$interactionOption.getOptionId() + TokenParser.SP + InteractionActionDialog$playOption$reqData$2.this.$interactionOption.getOptionText());
                        }
                    });
                }
            });
            return;
        }
        if (msg2.length() > 0) {
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            squareCommon.showToast(context, msg2, 1);
        }
        this.this$0.dismiss();
    }
}
