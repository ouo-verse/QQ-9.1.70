package com.tencent.mobileqq.ark.core;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.n;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ark/core/NotoColorEmojiHelper;", "", "", "c", "a", "Lcom/tencent/rdelivery/reshub/api/h;", "b", "Lcom/tencent/rdelivery/reshub/api/h;", "()Lcom/tencent/rdelivery/reshub/api/h;", "resultListener", "<init>", "()V", "qqark-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NotoColorEmojiHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NotoColorEmojiHelper f199321a = new NotoColorEmojiHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.rdelivery.reshub.api.h resultListener = new a();

    NotoColorEmojiHelper() {
    }

    @JvmStatic
    public static final void c() {
        f199321a.a();
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 35) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new NotoColorEmojiHelper$doPreload$1(null), 2, null);
        }
    }

    @NotNull
    public final com.tencent.rdelivery.reshub.api.h b() {
        return resultListener;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/ark/core/NotoColorEmojiHelper$a", "Lcom/tencent/rdelivery/reshub/api/h;", "", "v", "", "onProgress", "", "b", "Lcom/tencent/rdelivery/reshub/api/g;", "iRes", "Lcom/tencent/rdelivery/reshub/api/n;", "iResLoadError", "onComplete", "qqark-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.rdelivery.reshub.api.h {
        a() {
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(boolean b16, @Nullable com.tencent.rdelivery.reshub.api.g iRes, @NotNull n iResLoadError) {
            Intrinsics.checkNotNullParameter(iResLoadError, "iResLoadError");
            QLog.i("ArkApp.Emoji", 1, "get emoji ttf onComplete:" + iRes);
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float v3) {
        }
    }
}
