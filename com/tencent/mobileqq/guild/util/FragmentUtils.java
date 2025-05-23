package com.tencent.mobileqq.guild.util;

import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R#\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/util/FragmentUtils;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentContainer;", ParseCommon.CONTAINER, "", "b", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "a", "()Ljava/lang/reflect/Field;", "fragmentContainerField", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FragmentUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FragmentUtils f235325a = new FragmentUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fragmentContainerField;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Field>() { // from class: com.tencent.mobileqq.guild.util.FragmentUtils$fragmentContainerField$2
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() {
                Field declaredField = FragmentManager.class.getDeclaredField("mContainer");
                declaredField.setAccessible(true);
                return declaredField;
            }
        });
        fragmentContainerField = lazy;
    }

    FragmentUtils() {
    }

    private final Field a() {
        return (Field) fragmentContainerField.getValue();
    }

    public final void b(@NotNull FragmentManager fragmentManager, @NotNull FragmentContainer container) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(container, "container");
        a().set(fragmentManager, container);
    }
}
