package com.tencent.mobileqq.aio.msglist;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider;
import com.tencent.mobileqq.aio.msglist.holder.AIOItemViewHolderDelegate;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.anisticker.AIOAniStickerContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.AIOArkContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.file.AIOOnlineFileContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.flashpic.AIOFlashPicContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIORichContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.mix.AIOMixContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.AIOMsgStatusComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.multifoward.AIOMultifowardContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.multipci.AIOMultiPicContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.AIOPicContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.sysface.AIOSingleSysFaceContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.template.AIOTemplateMsgComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.videochat.AIOVideoResultContentComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJJ\u0010\f\u001a\u00020\u000b\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgItemFactoryProvider;", "Lcom/tencent/mobileqq/aio/msglist/x;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "T", "", "self", "Ljava/lang/Class;", "clazz", "needSendStatus", "allowCancelSend", "useActionSheetForResend", "Lcom/tencent/mobileqq/aio/msglist/holder/b;", "c", "Ljava/lang/reflect/Constructor;", "e", "", "viewType", "Lcom/tencent/mobileqq/aio/msglist/holder/i;", "f", "a", "", "Lz71/a;", "b", "Lkotlin/Lazy;", "g", "()Ljava/util/List;", "mExtFactoryProvider", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgItemFactoryProvider implements x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOMsgItemFactoryProvider f190341a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mExtFactoryProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<com.tencent.mobileqq.aio.msglist.holder.i> mItemViewHolderFactoryArray;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57908);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        AIOMsgItemFactoryProvider aIOMsgItemFactoryProvider = new AIOMsgItemFactoryProvider();
        f190341a = aIOMsgItemFactoryProvider;
        lazy = LazyKt__LazyJVMKt.lazy(AIOMsgItemFactoryProvider$mExtFactoryProvider$2.INSTANCE);
        mExtFactoryProvider = lazy;
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.i> sparseArray = new SparseArray<>();
        sparseArray.put(7, d(aIOMsgItemFactoryProvider, true, AIOTextContentComponent.class, false, false, false, 28, null));
        sparseArray.put(6, d(aIOMsgItemFactoryProvider, false, AIOTextContentComponent.class, false, false, false, 28, null));
        sparseArray.put(5, d(aIOMsgItemFactoryProvider, true, AIOPicContentComponent.class, false, false, false, 28, null));
        sparseArray.put(4, d(aIOMsgItemFactoryProvider, false, AIOPicContentComponent.class, false, false, false, 28, null));
        sparseArray.put(9, d(aIOMsgItemFactoryProvider, true, AIOFileContentComponent.class, false, false, false, 24, null));
        sparseArray.put(8, d(aIOMsgItemFactoryProvider, false, AIOFileContentComponent.class, false, false, false, 24, null));
        sparseArray.put(97, d(aIOMsgItemFactoryProvider, false, AIOMultiPicContentComponent.class, false, false, false, 28, null));
        sparseArray.put(96, d(aIOMsgItemFactoryProvider, true, AIOMultiPicContentComponent.class, false, false, false, 28, null));
        sparseArray.put(81, d(aIOMsgItemFactoryProvider, false, AIOOnlineFileContentComponent.class, false, false, false, 24, null));
        sparseArray.put(11, d(aIOMsgItemFactoryProvider, true, AIOVideoContentComponent.class, false, false, false, 24, null));
        sparseArray.put(10, d(aIOMsgItemFactoryProvider, false, AIOVideoContentComponent.class, false, false, false, 28, null));
        sparseArray.put(33, d(aIOMsgItemFactoryProvider, true, AIOMultifowardContentComponent.class, false, false, false, 28, null));
        sparseArray.put(32, d(aIOMsgItemFactoryProvider, false, AIOMultifowardContentComponent.class, false, false, false, 28, null));
        sparseArray.put(3, d(aIOMsgItemFactoryProvider, true, AIOMixContentComponent.class, false, false, false, 28, null));
        sparseArray.put(2, d(aIOMsgItemFactoryProvider, false, AIOMixContentComponent.class, false, false, false, 28, null));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$1$1.INSTANCE);
        Unit unit = Unit.INSTANCE;
        sparseArray.put(25, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate));
        sparseArray.put(26, d(aIOMsgItemFactoryProvider, true, AIORichContentComponent.class, false, false, false, 28, null));
        sparseArray.put(13, d(aIOMsgItemFactoryProvider, true, AIOPttContentComponent.class, false, false, false, 28, null));
        sparseArray.put(12, d(aIOMsgItemFactoryProvider, false, AIOPttContentComponent.class, false, false, false, 28, null));
        sparseArray.put(34, d(aIOMsgItemFactoryProvider, true, AIOArkContentComponent.class, false, false, false, 28, null));
        sparseArray.put(35, d(aIOMsgItemFactoryProvider, false, AIOArkContentComponent.class, false, false, false, 28, null));
        sparseArray.put(100, d(aIOMsgItemFactoryProvider, true, AIOTemplateMsgComponent.class, false, false, false, 28, null));
        sparseArray.put(101, d(aIOMsgItemFactoryProvider, false, AIOTemplateMsgComponent.class, false, false, false, 28, null));
        sparseArray.put(102, d(aIOMsgItemFactoryProvider, true, AIOPositionMsgComponent.class, false, false, false, 28, null));
        sparseArray.put(103, d(aIOMsgItemFactoryProvider, false, AIOPositionMsgComponent.class, false, false, false, 28, null));
        sparseArray.put(39, d(aIOMsgItemFactoryProvider, true, AIOVideoResultContentComponent.class, false, false, false, 28, null));
        sparseArray.put(38, d(aIOMsgItemFactoryProvider, false, AIOVideoResultContentComponent.class, false, false, false, 28, null));
        sparseArray.put(15, d(aIOMsgItemFactoryProvider, true, AIOAniStickerContentComponent.class, false, false, false, 28, null));
        sparseArray.put(14, d(aIOMsgItemFactoryProvider, false, AIOAniStickerContentComponent.class, false, false, false, 28, null));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate2 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate2.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$2$1.INSTANCE);
        aIOItemViewHolderDelegate2.f(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$2$2.INSTANCE);
        sparseArray.put(93, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate2));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate3 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate3.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$3$1.INSTANCE);
        aIOItemViewHolderDelegate3.f(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$3$2.INSTANCE);
        sparseArray.put(94, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate3));
        sparseArray.put(37, d(aIOMsgItemFactoryProvider, true, AIOMarketFaceComponent.class, false, false, false, 28, null));
        sparseArray.put(36, d(aIOMsgItemFactoryProvider, false, AIOMarketFaceComponent.class, false, false, false, 28, null));
        sparseArray.put(24, d(aIOMsgItemFactoryProvider, true, AIOReplyComponent.class, false, false, false, 28, null));
        sparseArray.put(23, d(aIOMsgItemFactoryProvider, false, AIOReplyComponent.class, false, false, false, 28, null));
        sparseArray.put(84, d(aIOMsgItemFactoryProvider, true, AIOFlashPicContentComponent.class, false, false, false, 28, null));
        sparseArray.put(85, d(aIOMsgItemFactoryProvider, false, AIOFlashPicContentComponent.class, false, false, false, 28, null));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate4 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate4.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$revokeTips$1$1.INSTANCE);
        aIOItemViewHolderDelegate4.f(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$revokeTips$1$2.INSTANCE);
        sparseArray.put(50, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate4));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate5 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate5.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$pushTips$1$1.INSTANCE);
        aIOItemViewHolderDelegate5.f(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$pushTips$1$2.INSTANCE);
        sparseArray.put(56, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate5));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate6 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate6.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$tofu$1$1.INSTANCE);
        aIOItemViewHolderDelegate6.f(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$tofu$1$2.INSTANCE);
        sparseArray.put(66, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate6));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate7 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate7.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$4$1.INSTANCE);
        sparseArray.put(70, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate7));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate8 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate8.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$5$1.INSTANCE);
        sparseArray.put(87, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate8));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate9 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate9.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$6$1.INSTANCE);
        aIOItemViewHolderDelegate9.f(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$6$2.INSTANCE);
        sparseArray.put(86, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate9));
        sparseArray.put(90, d(aIOMsgItemFactoryProvider, true, AIOSingleSysFaceContentComponent.class, false, false, false, 28, null));
        sparseArray.put(91, d(aIOMsgItemFactoryProvider, false, AIOSingleSysFaceContentComponent.class, false, false, false, 28, null));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate10 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate10.e(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$prologue$1$1.INSTANCE);
        aIOItemViewHolderDelegate10.f(AIOMsgItemFactoryProvider$mItemViewHolderFactoryArray$1$prologue$1$2.INSTANCE);
        sparseArray.put(95, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate10));
        mItemViewHolderFactoryArray = sparseArray;
    }

    AIOMsgItemFactoryProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final <T extends BaseContentComponent<?>> com.tencent.mobileqq.aio.msglist.holder.b c(boolean self, Class<T> clazz, final boolean needSendStatus, final boolean allowCancelSend, final boolean useActionSheetForResend) {
        final Constructor e16 = e(clazz);
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(new Function1<Context, com.tencent.mobileqq.aio.msglist.holder.g>(e16, needSendStatus, allowCancelSend, useActionSheetForResend) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryProvider$buildItemFactory$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $allowCancelSend;
            final /* synthetic */ Constructor<T> $constructor;
            final /* synthetic */ boolean $needSendStatus;
            final /* synthetic */ boolean $useActionSheetForResend;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$constructor = e16;
                this.$needSendStatus = needSendStatus;
                this.$allowCancelSend = allowCancelSend;
                this.$useActionSheetForResend = useActionSheetForResend;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, e16, Boolean.valueOf(needSendStatus), Boolean.valueOf(allowCancelSend), Boolean.valueOf(useActionSheetForResend));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.mobileqq.aio.msglist.holder.g invoke(@NotNull final Context context) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.aio.msglist.holder.g) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
                }
                Intrinsics.checkNotNullParameter(context, "context");
                AIOItemComponentProvider aIOItemComponentProvider = new AIOItemComponentProvider(context, null, new Function0<BaseContentComponent<?>>(this.$constructor, context) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryProvider$buildItemFactory$2$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Constructor<T> $constructor;
                    final /* synthetic */ Context $context;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$constructor = r4;
                        this.$context = context;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) r4, (Object) context);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final BaseContentComponent<?> invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (BaseContentComponent) this.$constructor.newInstance(this.$context) : (BaseContentComponent) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }, null, null, null, null, null, null, null, null, null, null, null, null, null, 65530, null);
                boolean z16 = this.$needSendStatus;
                final boolean z17 = this.$allowCancelSend;
                final boolean z18 = this.$useActionSheetForResend;
                if (!z16) {
                    aIOItemComponentProvider.s(AIOMsgItemFactoryProvider$buildItemFactory$2$1$2$1.INSTANCE);
                    return aIOItemComponentProvider;
                }
                if (!z17 && !z18) {
                    return aIOItemComponentProvider;
                }
                aIOItemComponentProvider.s(new Function0<AIOMsgStatusComponent>(context, z17, z18) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryProvider$buildItemFactory$2$1$2$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ boolean $allowCancelSend;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ boolean $useActionSheetForResend;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$context = context;
                        this.$allowCancelSend = z17;
                        this.$useActionSheetForResend = z18;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, context, Boolean.valueOf(z17), Boolean.valueOf(z18));
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final AIOMsgStatusComponent invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AIOMsgStatusComponent(this.$context, this.$allowCancelSend, this.$useActionSheetForResend) : (AIOMsgStatusComponent) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
                return aIOItemComponentProvider;
            }
        });
        if (self) {
            aIOItemViewHolderDelegate.f(AIOMsgItemFactoryProvider$buildItemFactory$2$2.INSTANCE);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate);
    }

    static /* synthetic */ com.tencent.mobileqq.aio.msglist.holder.b d(AIOMsgItemFactoryProvider aIOMsgItemFactoryProvider, boolean z16, Class cls, boolean z17, boolean z18, boolean z19, int i3, Object obj) {
        boolean z26;
        boolean z27;
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        boolean z28 = z17;
        if ((i3 & 8) != 0) {
            z26 = false;
        } else {
            z26 = z18;
        }
        if ((i3 & 16) != 0) {
            z27 = false;
        } else {
            z27 = z19;
        }
        return aIOMsgItemFactoryProvider.c(z16, cls, z28, z26, z27);
    }

    private final <T> Constructor<T> e(Class<T> clazz) {
        boolean z16;
        Object[] constructors = clazz.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "clazz.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "c.parameterTypes");
            if (parameterTypes.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryProvider.getConstructor>");
                return constructor;
            }
            if (constructor.getParameterTypes().length == 1 && Context.class.isAssignableFrom(constructor.getParameterTypes()[0])) {
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryProvider.getConstructor>");
                return constructor;
            }
        }
        throw new RuntimeException("'" + clazz + "' does not have constructor with one parameter of type 'Context'");
    }

    private final com.tencent.mobileqq.aio.msglist.holder.i f(int viewType) {
        Iterator<T> it = g().iterator();
        com.tencent.mobileqq.aio.msglist.holder.i iVar = null;
        while (it.hasNext() && (iVar = ((z71.a) it.next()).a(viewType)) == null) {
        }
        return iVar;
    }

    private final List<z71.a> g() {
        return (List) mExtFactoryProvider.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.x
    @NotNull
    public com.tencent.mobileqq.aio.msglist.holder.i a(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.i) iPatchRedirector.redirect((short) 2, (Object) this, viewType);
        }
        com.tencent.mobileqq.aio.msglist.holder.i iVar = mItemViewHolderFactoryArray.get(viewType);
        if (iVar == null) {
            com.tencent.mobileqq.aio.msglist.holder.i f16 = f(viewType);
            if (f16 == null) {
                AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
                aIOItemViewHolderDelegate.e(AIOMsgItemFactoryProvider$getItemViewHolderFactory$1$1.INSTANCE);
                if (viewType == 0) {
                    aIOItemViewHolderDelegate.f(AIOMsgItemFactoryProvider$getItemViewHolderFactory$1$2.INSTANCE);
                }
                return new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate);
            }
            return f16;
        }
        return iVar;
    }
}
