package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J(\u0010\u000b\u001a\u00020\u00052\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tH\u0007J2\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00022\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/af;", "", "", "b", "h5Url", "", "c", "Ljava/util/ArrayList;", "LUserGrowth/stRedDotMenu;", "Lkotlin/collections/ArrayList;", "menuList", "d", "menuKey", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    public static final af f81699a = new af();

    af() {
    }

    @JvmStatic
    public static final stRedDotMenu a(String menuKey, ArrayList<stRedDotMenu> menuList) {
        Intrinsics.checkNotNullParameter(menuKey, "menuKey");
        if (menuList == null) {
            return null;
        }
        Iterator<stRedDotMenu> it = menuList.iterator();
        while (it.hasNext()) {
            stRedDotMenu next = it.next();
            if (Intrinsics.areEqual(menuKey, next != null ? next.menuKey : null)) {
                return next;
            }
        }
        return null;
    }

    @JvmStatic
    public static final String b() {
        String string = LocalMultiProcConfig.getString("key_feedback_jump_url", "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(KEY_FEEDBACK_JUMP_URL, \"\")");
        return string;
    }

    @JvmStatic
    public static final void d(ArrayList<stRedDotMenu> menuList) {
        stSchema stschema;
        stRedDotMenu a16 = a("Feedback", menuList);
        String str = (a16 == null || (stschema = a16.schema) == null) ? null : stschema.H5Url;
        c(str);
        x.j("WSRedDotUtil", "feedBack url = " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(String h5Url) {
        boolean z16;
        boolean isBlank;
        if (h5Url != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(h5Url);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    LocalMultiProcConfig.putString("key_feedback_jump_url", h5Url);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }
}
