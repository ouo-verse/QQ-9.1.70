package com.tencent.aio.widget.textView.cache;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aio.widget.textView.creator.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/widget/textView/cache/c;", "Lcom/tencent/aio/widget/textView/creator/f$a;", "", "assetPath", "Landroid/content/Context;", "context", "Landroid/graphics/Typeface;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "typefaceCache", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class c implements f.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Typeface> typefaceCache;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final c f70002b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f70002b = new c();
            typefaceCache = new ConcurrentHashMap<>();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.aio.widget.textView.creator.f.a
    @Nullable
    public Typeface a(@Nullable String assetPath, @NotNull Context context) {
        Typeface createFromAsset;
        boolean contains$default;
        boolean contains$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Typeface) iPatchRedirector.redirect((short) 1, (Object) this, (Object) assetPath, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(assetPath)) {
            return null;
        }
        ConcurrentHashMap<String, Typeface> concurrentHashMap = typefaceCache;
        if (concurrentHashMap != null) {
            if (!concurrentHashMap.containsKey(assetPath)) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                        AssetManager assets = applicationContext.getAssets();
                        Intrinsics.checkNotNull(assetPath);
                        Typeface.Builder builder = new Typeface.Builder(assets, assetPath);
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) assetPath, (CharSequence) "medium", false, 2, (Object) null);
                        if (contains$default) {
                            builder.setWeight(700);
                        }
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) assetPath, (CharSequence) "italic", false, 2, (Object) null);
                        if (contains$default2) {
                            builder.setItalic(true);
                        }
                        createFromAsset = builder.build();
                        Intrinsics.checkNotNullExpressionValue(createFromAsset, "builder.build()");
                    } else {
                        Context applicationContext2 = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
                        AssetManager assets2 = applicationContext2.getAssets();
                        Intrinsics.checkNotNull(assetPath);
                        createFromAsset = Typeface.createFromAsset(assets2, assetPath);
                        Intrinsics.checkNotNullExpressionValue(createFromAsset, "Typeface.createFromAsset\u2026text.assets, assetPath!!)");
                    }
                    concurrentHashMap.put(assetPath, createFromAsset);
                } catch (Exception unused) {
                }
            }
            return typefaceCache.get(assetPath);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
}
