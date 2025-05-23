package com.tencent.ecommerce.base.ui.api;

import android.content.Context;
import android.view.LayoutInflater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "Lcom/tencent/ecommerce/base/ui/api/IECCoreSkinApi;", "Landroid/content/Context;", "context", "", "init", "loadResource", "Landroid/view/LayoutInflater$Factory2;", "getSkinFactory2", "Companion", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECSkinApi extends IECCoreSkinApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f101140a;

    @NotNull
    public static final String IMPL_CLASS_PATH = "com.tencent.ecommerce.base.ui.ECSkin";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/IECSkinApi$a;", "", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.ui.api.IECSkinApi$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f101140a = new Companion();

        Companion() {
        }
    }

    @Nullable
    LayoutInflater.Factory2 getSkinFactory2();

    void init(@NotNull Context context);

    void loadResource();
}
