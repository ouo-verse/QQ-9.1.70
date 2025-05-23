package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.text.Editable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0006B)\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0006\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditableFactory;", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "a", "Landroid/text/Editable$Factory;", "originalFactory", "", "Ljava/lang/Class;", "b", "[Ljava/lang/Class;", "blockSpans", "", "c", "I", "emoSize", "", "d", "Lkotlin/Lazy;", "()Z", "enable", "<init>", "(Landroid/text/Editable$Factory;[Ljava/lang/Class;I)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedEditableFactory extends Editable.Factory {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static ArrayList<Class<?>> f221894f = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Editable.Factory originalFactory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<?>[] blockSpans;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int emoSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy enable;

    public GuildFeedEditableFactory(@NotNull Editable.Factory originalFactory, @NotNull Class<?>[] blockSpans, int i3) {
        Lazy lazy;
        Class<?> loadClass;
        Class<?> loadClass2;
        Intrinsics.checkNotNullParameter(originalFactory, "originalFactory");
        Intrinsics.checkNotNullParameter(blockSpans, "blockSpans");
        this.originalFactory = originalFactory;
        this.blockSpans = blockSpans;
        this.emoSize = i3;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditableFactory$enable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105966", true));
            }
        });
        this.enable = lazy;
        try {
            ClassLoader classLoader = GuildFeedEditableFactory.class.getClassLoader();
            if (classLoader != null && (loadClass2 = classLoader.loadClass("android.text.DynamicLayout$ChangeWatcher")) != null) {
                f221894f.add(loadClass2);
            }
            ClassLoader classLoader2 = GuildFeedEditableFactory.class.getClassLoader();
            if (classLoader2 != null && (loadClass = classLoader2.loadClass("android.widget.TextView$ChangeWatcher")) != null) {
                f221894f.add(loadClass);
            }
        } catch (Throwable th5) {
            QLog.e("GuildFeedEditableFactory", 1, "reflection failed:", th5);
        }
    }

    private final boolean a() {
        return ((Boolean) this.enable.getValue()).booleanValue();
    }

    @Override // android.text.Editable.Factory
    @NotNull
    public Editable newEditable(@Nullable CharSequence source) {
        if (a() && (!f221894f.isEmpty())) {
            return new h(f221894f, this.blockSpans, source, 3, this.emoSize);
        }
        QLog.e("GuildFeedEditableFactory", 1, "[newEditable] sWatcher: " + f221894f.size() + ", enable: " + a() + ", use original factory.");
        Editable newEditable = this.originalFactory.newEditable(source);
        Intrinsics.checkNotNullExpressionValue(newEditable, "{\n            QLog.e(TAG\u2026ditable(source)\n        }");
        return newEditable;
    }
}
