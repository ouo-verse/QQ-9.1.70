package c84;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lc84/c;", "", "", "b", "Ljava/lang/String;", "getNORMAL_TEXT", "()Ljava/lang/String;", "NORMAL_TEXT", "c", "getHOT_FIX_PREFIX", "HOT_FIX_PREFIX", "d", "a", "LOADING_TEXT", "e", "getHOT_FIX_HINT_TEMPLATE", "HOT_FIX_HINT_TEMPLATE", "<init>", "()V", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f30451a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String NORMAL_TEXT;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String HOT_FIX_PREFIX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String LOADING_TEXT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final String HOT_FIX_HINT_TEMPLATE;

    static {
        String string = BaseApplication.context.getResources().getString(R.string.xql);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_loading_hint_txt_normal)");
        NORMAL_TEXT = string;
        String string2 = BaseApplication.context.getResources().getString(R.string.xqj);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026ding_hint_hot_fix_prefix)");
        HOT_FIX_PREFIX = string2;
        String string3 = BaseApplication.context.getResources().getString(R.string.xqk);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026loading_hint_txt_loading)");
        LOADING_TEXT = string3;
        String string4 = BaseApplication.context.getResources().getString(R.string.xqi);
        Intrinsics.checkNotNullExpressionValue(string4, "context.resources.getStr\u2026ding_hint_download_files)");
        HOT_FIX_HINT_TEMPLATE = string4;
    }

    c() {
    }

    public final String a() {
        return LOADING_TEXT;
    }
}
