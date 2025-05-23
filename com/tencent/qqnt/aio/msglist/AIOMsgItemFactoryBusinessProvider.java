package com.tencent.qqnt.aio.msglist;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider;
import com.tencent.mobileqq.aio.msglist.holder.AIOItemViewHolderDelegate;
import com.tencent.mobileqq.aio.msglist.holder.b;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.g;
import com.tencent.mobileqq.aio.msglist.holder.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.sample.BusinessSampleContentComponent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z71.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J6\u0010\n\u001a\u00020\t\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/msglist/AIOMsgItemFactoryBusinessProvider;", "Lz71/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "T", "", "self", "Ljava/lang/Class;", "clazz", "needSendStatus", "Lcom/tencent/mobileqq/aio/msglist/holder/b;", "c", "Ljava/lang/reflect/Constructor;", "e", "", "viewType", "Lcom/tencent/mobileqq/aio/msglist/holder/i;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMsgItemFactoryBusinessProvider implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<i> mItemViewHolderFactoryArray;

    public AIOMsgItemFactoryBusinessProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        SparseArray<i> sparseArray = new SparseArray<>();
        sparseArray.put(Integer.MAX_VALUE, d(this, true, BusinessSampleContentComponent.class, false, 4, null));
        this.mItemViewHolderFactoryArray = sparseArray;
    }

    private final <T extends BaseContentComponent<?>> b c(boolean self, Class<T> clazz, final boolean needSendStatus) {
        final Constructor e16 = e(clazz);
        AIOItemViewHolderDelegate aIOItemViewHolderDelegate = new AIOItemViewHolderDelegate();
        aIOItemViewHolderDelegate.e(new Function1<Context, g>(e16, needSendStatus) { // from class: com.tencent.qqnt.aio.msglist.AIOMsgItemFactoryBusinessProvider$buildItemFactory$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Constructor<T> $constructor;
            final /* synthetic */ boolean $needSendStatus;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$constructor = e16;
                this.$needSendStatus = needSendStatus;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, e16, Boolean.valueOf(needSendStatus));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final g invoke(@NotNull Context context) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
                }
                Intrinsics.checkNotNullParameter(context, "context");
                AIOItemComponentProvider aIOItemComponentProvider = new AIOItemComponentProvider(context, null, new Function0<BaseContentComponent<?>>(this.$constructor, context) { // from class: com.tencent.qqnt.aio.msglist.AIOMsgItemFactoryBusinessProvider$buildItemFactory$1$1.1
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
                if (this.$needSendStatus) {
                    return aIOItemComponentProvider;
                }
                aIOItemComponentProvider.s(AIOMsgItemFactoryBusinessProvider$buildItemFactory$1$1$2$1.INSTANCE);
                return aIOItemComponentProvider;
            }
        });
        if (self) {
            aIOItemViewHolderDelegate.f(AIOMsgItemFactoryBusinessProvider$buildItemFactory$1$2.INSTANCE);
        }
        return new b(aIOItemViewHolderDelegate);
    }

    static /* synthetic */ b d(AIOMsgItemFactoryBusinessProvider aIOMsgItemFactoryBusinessProvider, boolean z16, Class cls, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return aIOMsgItemFactoryBusinessProvider.c(z16, cls, z17);
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
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.tencent.qqnt.aio.msglist.AIOMsgItemFactoryBusinessProvider.getConstructor>");
                return constructor;
            }
            if (constructor.getParameterTypes().length == 1 && Context.class.isAssignableFrom(constructor.getParameterTypes()[0])) {
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.tencent.qqnt.aio.msglist.AIOMsgItemFactoryBusinessProvider.getConstructor>");
                return constructor;
            }
        }
        throw new RuntimeException("'" + clazz + "' does not have constructor with one parameter of type 'Context'");
    }

    @Override // com.tencent.mobileqq.aio.msglist.x
    @Nullable
    public i a(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this, viewType);
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
        if (msgRecord.msgType == Integer.MAX_VALUE) {
            return new com.tencent.qqnt.aio.sample.a(msgRecord);
        }
        return null;
    }
}
