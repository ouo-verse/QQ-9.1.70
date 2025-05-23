package com.tencent.mobileqq.wink.editor.util;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fH\u0002J\"\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0013\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/i;", "", "Landroid/content/Intent;", "intent", "", "key", "", "default", "a", "Landroid/os/Bundle;", "bundle", "b", "", "e", "g", "c", "j", tl.h.F, "i", "d", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "f", "", "k", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f322640a = new i();

    i() {
    }

    private final boolean a(Intent intent, String key, boolean r36) {
        if (intent != null) {
            return intent.getBooleanExtra(key, r36);
        }
        return r36;
    }

    private final boolean b(Bundle bundle, String key, boolean r36) {
        if (bundle != null) {
            return bundle.getBoolean(key, r36);
        }
        return r36;
    }

    private final int e(Intent intent, String key, int r36) {
        if (intent != null) {
            return intent.getIntExtra(key, r36);
        }
        return r36;
    }

    private final String g(Intent intent, String key, String r36) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra(key);
        } else {
            str = null;
        }
        if (str != null) {
            return str;
        }
        return r36;
    }

    @NotNull
    public final String c(@Nullable Intent intent) {
        return g(intent, QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
    }

    public final int d(@Nullable Intent intent) {
        return e(intent, QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 0);
    }

    @NotNull
    public final MenuType f(@Nullable Bundle bundle) {
        if (b(bundle, QQWinkConstants.IS_FROM_CROP, false)) {
            return MenuType.CROP;
        }
        if (b(bundle, QQWinkConstants.IS_FROM_CLIP, false)) {
            return MenuType.CLIPPING;
        }
        if (b(bundle, QQWinkConstants.IS_FROM_MOSAIC, false)) {
            return MenuType.MOSAIC;
        }
        if (b(bundle, QQWinkConstants.IS_FROM_ELIMINATION, false)) {
            return MenuType.AI_ELIMINATION;
        }
        return MenuType.BOTTOM_DASHBOARD;
    }

    public final boolean h(@Nullable Intent intent) {
        return a(intent, QQWinkConstants.EDITOR_ENABLE_MUSIC, true);
    }

    public final boolean i(@Nullable Intent intent) {
        return a(intent, QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, true);
    }

    public final boolean j(@Nullable Intent intent) {
        boolean z16;
        Serializable serializable;
        HashMap hashMap;
        boolean equals$default;
        if (intent != null && intent.getIntExtra("edit_image_mode", 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (intent != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            equals$default = StringsKt__StringsJVMKt.equals$default((String) hashMap.get("edit_image_mode"), "1", false, 2, null);
            return equals$default;
        }
        return false;
    }

    public final void k(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putBoolean(QQWinkConstants.IS_FROM_CROP, false);
        bundle.putBoolean(QQWinkConstants.IS_FROM_CLIP, false);
        bundle.putBoolean(QQWinkConstants.IS_FROM_ELIMINATION, false);
        bundle.putBoolean(QQWinkConstants.IS_FROM_MOSAIC, false);
    }
}
