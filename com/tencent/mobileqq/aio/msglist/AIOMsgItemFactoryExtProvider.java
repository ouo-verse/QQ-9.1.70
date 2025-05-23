package com.tencent.mobileqq.aio.msglist;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.aio.aiogift.AIOTroopGiftComponent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.FaceBubbleMsgItem;
import com.tencent.mobileqq.aio.msg.LocationShareMsgItem;
import com.tencent.mobileqq.aio.msg.PokeMsgItem;
import com.tencent.mobileqq.aio.msg.PositionMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.ZPlanMsgItem;
import com.tencent.mobileqq.aio.msg.ai;
import com.tencent.mobileqq.aio.msg.template.impl.PositionMsgApiImpl;
import com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider;
import com.tencent.mobileqq.aio.msglist.holder.AIOItemViewHolderDelegate;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.LocationShare.AIOLocationShareComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ickbreak.AIOIceBreakContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.select.AIOSelectComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.select.EmptySelectComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.zplan.AIOZPlanContentComponent;
import com.tencent.mobileqq.aio.qwallet.AIOQWalletComponent;
import com.tencent.mobileqq.aio.qwallet.api.IQWalletAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ@\u0010\u000b\u001a\u00020\n\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002J\u0018\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgItemFactoryExtProvider;", "Lz71/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "T", "", "self", "Ljava/lang/Class;", "clazz", "needSendStatus", "supportSelect", "Lcom/tencent/mobileqq/aio/msglist/holder/b;", "e", "c", "g", "d", "Ljava/lang/reflect/Constructor;", tl.h.F, "", "viewType", "Lcom/tencent/mobileqq/aio/msglist/holder/i;", "kotlin.jvm.PlatformType", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgItemFactoryExtProvider implements z71.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<com.tencent.mobileqq.aio.msglist.holder.i> mItemViewHolderFactoryArray;

    public AIOMsgItemFactoryExtProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.i> sparseArray = new SparseArray<>();
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$1$1.INSTANCE);
        aIOItemViewHolderDelegate.f(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$1$2.INSTANCE);
        Unit unit = Unit.INSTANCE;
        sparseArray.put(68, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate2 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate2.e(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$2$1.INSTANCE);
        sparseArray.put(67, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate2));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate3 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate3.e(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$3$1.INSTANCE);
        aIOItemViewHolderDelegate3.f(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$3$2.INSTANCE);
        sparseArray.put(75, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate3));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate4 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate4.e(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$4$1.INSTANCE);
        sparseArray.put(76, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate4));
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        sparseArray.put(28, f(this, true, AIOQWalletComponent.class, ((IQWalletAIOApi) companion.a(IQWalletAIOApi.class)).isHbMsgMultiSelect(), false, 8, null));
        sparseArray.put(27, f(this, false, AIOQWalletComponent.class, ((IQWalletAIOApi) companion.a(IQWalletAIOApi.class)).isHbMsgMultiSelect(), false, 8, null));
        sparseArray.put(43, f(this, true, AIOQWalletComponent.class, false, false, 4, null));
        sparseArray.put(42, f(this, false, AIOQWalletComponent.class, false, false, 4, null));
        sparseArray.put(69, c());
        sparseArray.put(92, g());
        sparseArray.put(98, d());
        sparseArray.put(31, f(this, true, AIOTroopGiftComponent.class, false, false, 12, null));
        sparseArray.put(30, f(this, false, AIOTroopGiftComponent.class, false, false, 12, null));
        sparseArray.put(77, f(this, true, AIOLocationShareComponent.class, false, false, 12, null));
        sparseArray.put(78, f(this, false, AIOLocationShareComponent.class, false, false, 12, null));
        sparseArray.put(79, f(this, true, AIOIceBreakContentComponent.class, false, false, 12, null));
        sparseArray.put(80, f(this, false, AIOIceBreakContentComponent.class, false, false, 12, null));
        sparseArray.put(88, f(this, true, AIOZPlanContentComponent.class, false, false, 12, null));
        sparseArray.put(89, f(this, false, AIOZPlanContentComponent.class, false, false, 12, null));
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate5 = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate5.e(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$5$1.INSTANCE);
        aIOItemViewHolderDelegate5.f(AIOMsgItemFactoryExtProvider$mItemViewHolderFactoryArray$1$5$2.INSTANCE);
        sparseArray.put(99, new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate5));
        this.mItemViewHolderFactoryArray = sparseArray;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.b c() {
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(AIOMsgItemFactoryExtProvider$buildCenterArkItemFactory$1$1.INSTANCE);
        aIOItemViewHolderDelegate.f(AIOMsgItemFactoryExtProvider$buildCenterArkItemFactory$1$2.INSTANCE);
        return new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate);
    }

    private final com.tencent.mobileqq.aio.msglist.holder.b d() {
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(AIOMsgItemFactoryExtProvider$buildCenterNoTimestampArkItemFactory$1$1.INSTANCE);
        aIOItemViewHolderDelegate.f(AIOMsgItemFactoryExtProvider$buildCenterNoTimestampArkItemFactory$1$2.INSTANCE);
        return new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate);
    }

    private final <T extends BaseContentComponent<?>> com.tencent.mobileqq.aio.msglist.holder.b e(boolean self, Class<T> clazz, final boolean needSendStatus, final boolean supportSelect) {
        final Constructor h16 = h(clazz);
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(new Function1<Context, com.tencent.mobileqq.aio.msglist.holder.g>(supportSelect, h16, needSendStatus) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryExtProvider$buildItemFactory$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Constructor<T> $constructor;
            final /* synthetic */ boolean $needSendStatus;
            final /* synthetic */ boolean $supportSelect;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$supportSelect = supportSelect;
                this.$constructor = h16;
                this.$needSendStatus = needSendStatus;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(supportSelect), h16, Boolean.valueOf(needSendStatus));
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
                AIOItemComponentProvider aIOItemComponentProvider = new AIOItemComponentProvider(context, null, new Function0<BaseContentComponent<?>>(this.$constructor, context) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryExtProvider$buildItemFactory$1$1.1
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
                }, null, this.$supportSelect ? new Function0<com.tencent.mobileqq.aio.msglist.holder.component.c>(context) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryExtProvider$buildItemFactory$1$1$selectComponentGetter$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Context $context;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$context = context;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final com.tencent.mobileqq.aio.msglist.holder.component.c invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AIOSelectComponent(this.$context) : (com.tencent.mobileqq.aio.msglist.holder.component.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                } : new Function0<com.tencent.mobileqq.aio.msglist.holder.component.c>(context) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryExtProvider$buildItemFactory$1$1$selectComponentGetter$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Context $context;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$context = context;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final com.tencent.mobileqq.aio.msglist.holder.component.c invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new EmptySelectComponent(this.$context) : (com.tencent.mobileqq.aio.msglist.holder.component.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }, null, null, null, null, null, null, null, null, null, null, null, 65514, null);
                if (this.$needSendStatus) {
                    return aIOItemComponentProvider;
                }
                aIOItemComponentProvider.s(AIOMsgItemFactoryExtProvider$buildItemFactory$1$1$2$1.INSTANCE);
                return aIOItemComponentProvider;
            }
        });
        if (self) {
            aIOItemViewHolderDelegate.f(AIOMsgItemFactoryExtProvider$buildItemFactory$1$2.INSTANCE);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate);
    }

    static /* synthetic */ com.tencent.mobileqq.aio.msglist.holder.b f(AIOMsgItemFactoryExtProvider aIOMsgItemFactoryExtProvider, boolean z16, Class cls, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        if ((i3 & 8) != 0) {
            z18 = true;
        }
        return aIOMsgItemFactoryExtProvider.e(z16, cls, z17, z18);
    }

    private final com.tencent.mobileqq.aio.msglist.holder.b g() {
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(AIOMsgItemFactoryExtProvider$buildShopArkItemFactory$1$1.INSTANCE);
        aIOItemViewHolderDelegate.f(AIOMsgItemFactoryExtProvider$buildShopArkItemFactory$1$2.INSTANCE);
        return new com.tencent.mobileqq.aio.msglist.holder.b(aIOItemViewHolderDelegate);
    }

    private final <T> Constructor<T> h(Class<T> clazz) {
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
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryExtProvider.getConstructor>");
                return constructor;
            }
            if (constructor.getParameterTypes().length == 1 && Context.class.isAssignableFrom(constructor.getParameterTypes()[0])) {
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryExtProvider.getConstructor>");
                return constructor;
            }
        }
        throw new RuntimeException("'" + clazz + "' does not have constructor with one parameter of type 'Context'");
    }

    @Override // com.tencent.mobileqq.aio.msglist.x
    public com.tencent.mobileqq.aio.msglist.holder.i a(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.i) iPatchRedirector.redirect((short) 2, (Object) this, viewType);
        }
        return this.mItemViewHolderFactoryArray.get(viewType);
    }

    @Override // z71.a
    @Nullable
    public AIOMsgItem b(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        int i3 = msgRecord.msgType;
        if (i3 != 2) {
            if (i3 != 15) {
                if (i3 != 29) {
                    if (i3 != 10) {
                        if (i3 != 11) {
                            if (i3 != 24) {
                                if (i3 != 25) {
                                    return null;
                                }
                                return new LocationShareMsgItem(msgRecord);
                            }
                            return new FaceBubbleMsgItem(msgRecord);
                        }
                        if (com.tencent.mobileqq.aio.utils.d.P(msgRecord)) {
                            return new ai(msgRecord);
                        }
                        if (com.tencent.mobileqq.aio.utils.d.V(msgRecord)) {
                            return new com.tencent.mobileqq.aio.shop.g(msgRecord);
                        }
                        if (com.tencent.mobileqq.aio.utils.d.M(msgRecord) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(PositionMsgApiImpl.CONFIG_ID, false)) {
                            return new PositionMsgItem(msgRecord);
                        }
                        if (com.tencent.mobileqq.aio.utils.d.Y(msgRecord)) {
                            return new TemplateMsgItem(msgRecord);
                        }
                        return new ArkMsgItem(msgRecord);
                    }
                    return new f81.b(msgRecord);
                }
                return new com.tencent.mobileqq.aio.msg.r(msgRecord);
            }
            return new ai(msgRecord);
        }
        if (MsgExtKt.O(msgRecord)) {
            return new PokeMsgItem(msgRecord);
        }
        if (!MsgExtKt.b0(msgRecord)) {
            return null;
        }
        return new ZPlanMsgItem(msgRecord);
    }
}
