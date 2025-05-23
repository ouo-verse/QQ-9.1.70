package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\r\u000eB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog$b;", "itemClickListener", "", "O", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog$b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PayTypeSelectedDialog extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b itemClickListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog$b;", "", "", "type", "", NodeProps.ON_CLICK, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void onClick(int type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayTypeSelectedDialog(@NotNull final Context context) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        final ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setBackgroundColor(Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(o.i(296), o.i(202));
        layoutParams.topToTop = 0;
        layoutParams.bottomToTop = R.id.f67033c9;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.verticalChainStyle = 2;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ((ViewUtils.getScreenHeight() - o.i(84)) - o.i(202)) / 2;
        Unit unit = Unit.INSTANCE;
        o.a(constraintLayout, R.id.f67043c_, layoutParams, new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                final LinearLayout linearLayout = new LinearLayout(context);
                final Context context2 = context;
                final PayTypeSelectedDialog payTypeSelectedDialog = this;
                o.r(linearLayout, o.i(28));
                o.q(linearLayout, o.i(28));
                o.s(linearLayout, o.i(24));
                o.p(linearLayout, o.i(28));
                linearLayout.setBackground(o.k(linearLayout, R.drawable.la8));
                linearLayout.setGravity(1);
                linearLayout.setOrientation(1);
                o.c(linearLayout, new LinearLayout.LayoutParams(-2, -2), new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final TextView invoke() {
                        LinearLayout linearLayout2 = linearLayout;
                        final Context context3 = context2;
                        return o.v(linearLayout2, new Function1<TextView, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                                invoke2(textView);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull TextView text) {
                                Intrinsics.checkNotNullParameter(text, "$this$text");
                                text.setText(context3.getString(R.string.f2175661c));
                                text.setTextSize(o.u(17));
                                text.setTextColor(o.g(-16777216, 0, 2, null));
                            }
                        });
                    }
                });
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(o.i(240), o.i(45));
                layoutParams2.topMargin = o.i(24);
                o.c(linearLayout, layoutParams2, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$3

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                    /* renamed from: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$3$1, reason: invalid class name */
                    /* loaded from: classes20.dex */
                    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
                        final /* synthetic */ Context $context;
                        final /* synthetic */ PayTypeSelectedDialog this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Context context, PayTypeSelectedDialog payTypeSelectedDialog) {
                            super(1);
                            this.$context = context;
                            this.this$0 = payTypeSelectedDialog;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void b(PayTypeSelectedDialog this$0, View view) {
                            PayTypeSelectedDialog.b bVar;
                            EventCollector.getInstance().onViewClickedBefore(view);
                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                            bVar = this$0.itemClickListener;
                            if (bVar != null) {
                                bVar.onClick(0);
                            }
                            this$0.dismiss();
                            EventCollector.getInstance().onViewClicked(view);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                            invoke2(textView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull TextView text) {
                            Intrinsics.checkNotNullParameter(text, "$this$text");
                            text.setCompoundDrawables(o.j(this.$context, R.drawable.npd), null, null, null);
                            text.setText(this.$context.getString(R.string.f2175461a));
                            text.setTextSize(o.u(17));
                            text.setTextColor(o.g(-1, 0, 2, null));
                            text.setBackgroundResource(R.drawable.la_);
                            final PayTypeSelectedDialog payTypeSelectedDialog = this.this$0;
                            text.setOnClickListener(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE 
                                  (r6v0 'text' android.widget.TextView)
                                  (wrap:android.view.View$OnClickListener:0x003c: CONSTRUCTOR (r1v4 'payTypeSelectedDialog' com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog):void (m), WRAPPED] call: com.tencent.mobileqq.vas.pay.page.d.<init>(com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog):void type: CONSTRUCTOR)
                                 VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$3.1.invoke(android.widget.TextView):void, file: classes20.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.vas.pay.page.d, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 15 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "$this$text"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                                android.content.Context r0 = r5.$context
                                r1 = 2131243997(0x7f0833dd, float:1.810443E38)
                                android.graphics.drawable.Drawable r0 = com.tencent.mobileqq.vas.pay.page.o.j(r0, r1)
                                r1 = 0
                                r6.setCompoundDrawables(r0, r1, r1, r1)
                                android.content.Context r0 = r5.$context
                                r2 = 2131912997(0x7f126925, float:1.9461323E38)
                                java.lang.String r0 = r0.getString(r2)
                                r6.setText(r0)
                                r0 = 17
                                float r2 = com.tencent.mobileqq.vas.pay.page.o.u(r0)
                                r6.setTextSize(r2)
                                r2 = 0
                                r3 = 2
                                r4 = -1
                                int r1 = com.tencent.mobileqq.vas.pay.page.o.g(r4, r2, r3, r1)
                                r6.setTextColor(r1)
                                r1 = 2131247053(0x7f083fcd, float:1.8110628E38)
                                r6.setBackgroundResource(r1)
                                com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog r1 = r5.this$0
                                com.tencent.mobileqq.vas.pay.page.d r2 = new com.tencent.mobileqq.vas.pay.page.d
                                r2.<init>(r1)
                                r6.setOnClickListener(r2)
                                r6.setGravity(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$3.AnonymousClass1.invoke2(android.widget.TextView):void");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final TextView invoke() {
                        return o.v(linearLayout, new AnonymousClass1(context2, payTypeSelectedDialog));
                    }
                });
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(o.i(240), o.i(45));
                layoutParams3.topMargin = o.i(12);
                o.c(linearLayout, layoutParams3, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$5

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                    /* renamed from: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$5$1, reason: invalid class name */
                    /* loaded from: classes20.dex */
                    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
                        final /* synthetic */ Context $context;
                        final /* synthetic */ PayTypeSelectedDialog this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Context context, PayTypeSelectedDialog payTypeSelectedDialog) {
                            super(1);
                            this.$context = context;
                            this.this$0 = payTypeSelectedDialog;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void b(PayTypeSelectedDialog this$0, View view) {
                            PayTypeSelectedDialog.b bVar;
                            EventCollector.getInstance().onViewClickedBefore(view);
                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                            bVar = this$0.itemClickListener;
                            if (bVar != null) {
                                bVar.onClick(1);
                            }
                            this$0.dismiss();
                            EventCollector.getInstance().onViewClicked(view);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                            invoke2(textView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull TextView text) {
                            Intrinsics.checkNotNullParameter(text, "$this$text");
                            text.setCompoundDrawables(o.j(this.$context, R.drawable.npe), null, null, null);
                            text.setText(this.$context.getString(R.string.f2175561b));
                            text.setTextSize(o.u(17));
                            text.setTextColor(o.g(-1, 0, 2, null));
                            text.setBackgroundResource(R.drawable.laa);
                            final PayTypeSelectedDialog payTypeSelectedDialog = this.this$0;
                            text.setOnClickListener(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE 
                                  (r6v0 'text' android.widget.TextView)
                                  (wrap:android.view.View$OnClickListener:0x003c: CONSTRUCTOR (r1v4 'payTypeSelectedDialog' com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog):void (m), WRAPPED] call: com.tencent.mobileqq.vas.pay.page.e.<init>(com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog):void type: CONSTRUCTOR)
                                 VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$5.1.invoke(android.widget.TextView):void, file: classes20.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.vas.pay.page.e, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 15 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "$this$text"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                                android.content.Context r0 = r5.$context
                                r1 = 2131243998(0x7f0833de, float:1.8104432E38)
                                android.graphics.drawable.Drawable r0 = com.tencent.mobileqq.vas.pay.page.o.j(r0, r1)
                                r1 = 0
                                r6.setCompoundDrawables(r0, r1, r1, r1)
                                android.content.Context r0 = r5.$context
                                r2 = 2131912998(0x7f126926, float:1.9461325E38)
                                java.lang.String r0 = r0.getString(r2)
                                r6.setText(r0)
                                r0 = 17
                                float r2 = com.tencent.mobileqq.vas.pay.page.o.u(r0)
                                r6.setTextSize(r2)
                                r2 = 0
                                r3 = 2
                                r4 = -1
                                int r1 = com.tencent.mobileqq.vas.pay.page.o.g(r4, r2, r3, r1)
                                r6.setTextColor(r1)
                                r1 = 2131247054(0x7f083fce, float:1.811063E38)
                                r6.setBackgroundResource(r1)
                                com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog r1 = r5.this$0
                                com.tencent.mobileqq.vas.pay.page.e r2 = new com.tencent.mobileqq.vas.pay.page.e
                                r2.<init>(r1)
                                r6.setOnClickListener(r2)
                                r6.setGravity(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$2$1$5.AnonymousClass1.invoke2(android.widget.TextView):void");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final TextView invoke() {
                        return o.v(linearLayout, new AnonymousClass1(context2, payTypeSelectedDialog));
                    }
                });
                return linearLayout;
            }
        });
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(o.i(40), o.i(40));
        layoutParams2.topToBottom = R.id.f67043c_;
        layoutParams2.startToStart = R.id.f67043c_;
        layoutParams2.endToEnd = R.id.f67043c_;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(44);
        o.a(constraintLayout, R.id.f67033c9, layoutParams2, new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$4

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$4$1, reason: invalid class name */
            /* loaded from: classes20.dex */
            public static final class AnonymousClass1 extends Lambda implements Function1<ImageView, Unit> {
                final /* synthetic */ PayTypeSelectedDialog this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PayTypeSelectedDialog payTypeSelectedDialog) {
                    super(1);
                    this.this$0 = payTypeSelectedDialog;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(PayTypeSelectedDialog this$0, View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.dismiss();
                    EventCollector.getInstance().onViewClicked(view);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                    invoke2(imageView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ImageView image) {
                    Intrinsics.checkNotNullParameter(image, "$this$image");
                    image.setBackgroundResource(R.drawable.guild_card_dialog_close);
                    final PayTypeSelectedDialog payTypeSelectedDialog = this.this$0;
                    image.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE 
                          (r3v0 'image' android.widget.ImageView)
                          (wrap:android.view.View$OnClickListener:0x0010: CONSTRUCTOR (r0v2 'payTypeSelectedDialog' com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog):void (m), WRAPPED] call: com.tencent.mobileqq.vas.pay.page.f.<init>(com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$4.1.invoke(android.widget.ImageView):void, file: classes20.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.vas.pay.page.f, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "$this$image"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        r0 = 2131234952(0x7f081088, float:1.8086084E38)
                        r3.setBackgroundResource(r0)
                        com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog r0 = r2.this$0
                        com.tencent.mobileqq.vas.pay.page.f r1 = new com.tencent.mobileqq.vas.pay.page.f
                        r1.<init>(r0)
                        r3.setOnClickListener(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog$1$4.AnonymousClass1.invoke2(android.widget.ImageView):void");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                return o.m(ConstraintLayout.this, new AnonymousClass1(this));
            }
        });
        setContentView(constraintLayout);
    }

    public final void O(@NotNull b itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }
}
