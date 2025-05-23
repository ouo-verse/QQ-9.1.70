package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ScopesHolderForClass<T extends MemberScope> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final ClassDescriptor classDescriptor;

    @NotNull
    private final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;

    @NotNull
    private final Function1<KotlinTypeRefiner, T> scopeFactory;

    @NotNull
    private final NotNullLazyValue scopeForOwnerModule$delegate;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T extends MemberScope> ScopesHolderForClass<T> create(@NotNull ClassDescriptor classDescriptor, @NotNull StorageManager storageManager, @NotNull KotlinTypeRefiner kotlinTypeRefinerForOwnerModule, @NotNull Function1<? super KotlinTypeRefiner, ? extends T> scopeFactory) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(scopeFactory, "scopeFactory");
            return new ScopesHolderForClass<>(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }

        Companion() {
        }
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, storageManager, function1, kotlinTypeRefiner);
    }

    private final T getScopeForOwnerModule() {
        return (T) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }

    @NotNull
    public final T getScope(@NotNull final KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor))) {
            return getScopeForOwnerModule();
        }
        TypeConstructor typeConstructor = this.classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        if (!kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor)) {
            return getScopeForOwnerModule();
        }
        return (T) kotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, new Function0<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$getScope$1
            final /* synthetic */ ScopesHolderForClass<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope invoke() {
                Function1 function1;
                function1 = ((ScopesHolderForClass) this.this$0).scopeFactory;
                return (MemberScope) function1.invoke(kotlinTypeRefiner);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1<? super KotlinTypeRefiner, ? extends T> function1, KotlinTypeRefiner kotlinTypeRefiner) {
        this.classDescriptor = classDescriptor;
        this.scopeFactory = function1;
        this.kotlinTypeRefinerForOwnerModule = kotlinTypeRefiner;
        this.scopeForOwnerModule$delegate = storageManager.createLazyValue(new Function0<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$scopeForOwnerModule$2
            final /* synthetic */ ScopesHolderForClass<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope invoke() {
                Function1 function12;
                KotlinTypeRefiner kotlinTypeRefiner2;
                function12 = ((ScopesHolderForClass) this.this$0).scopeFactory;
                kotlinTypeRefiner2 = ((ScopesHolderForClass) this.this$0).kotlinTypeRefinerForOwnerModule;
                return (MemberScope) function12.invoke(kotlinTypeRefiner2);
            }
        });
    }
}
