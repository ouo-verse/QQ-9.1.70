package com.tencent.mobileqq.search.searchdetail.content.wxminapp;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/c;", "", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/SpecialAction;", "specialAction", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f284375a = new c();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284376a;

        static {
            int[] iArr = new int[SpecialAction.values().length];
            try {
                iArr[SpecialAction.ACTION_CHANGE_TAB_TO_MINI_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpecialAction.ACTION_MINI_APP_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpecialAction.ACTION_MINI_GAME_MORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpecialAction.ACTION_MINI_GAME_SELECTED_FILTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f284376a = iArr;
        }
    }

    c() {
    }

    public static /* synthetic */ int b(c cVar, int i3, SpecialAction specialAction, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            specialAction = null;
        }
        return cVar.a(i3, specialAction);
    }

    public final int a(int querySource, @Nullable SpecialAction specialAction) {
        if (specialAction != null) {
            int i3 = a.f284376a[specialAction.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 || i3 == 3) {
                    return 8;
                }
                if (i3 == 4) {
                    return 6;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 10;
        }
        if (querySource != 1) {
            if (querySource != 2) {
                if (querySource != 6) {
                    if (querySource == 7) {
                        return 1;
                    }
                    if (querySource != 12) {
                        if (querySource != 16) {
                            if (querySource != 27) {
                                switch (querySource) {
                                    case 19:
                                        return 33;
                                    case 20:
                                        return 56;
                                    case 21:
                                        break;
                                    default:
                                        switch (querySource) {
                                            case 34:
                                            case 35:
                                                return 139;
                                            case 36:
                                                return 136;
                                            case 37:
                                                break;
                                            default:
                                                switch (querySource) {
                                                    case 39:
                                                    case 41:
                                                        return 84;
                                                    case 40:
                                                    case 42:
                                                        return 56;
                                                    default:
                                                        return -1;
                                                }
                                        }
                                }
                            }
                            return 67;
                        }
                    } else {
                        return 20;
                    }
                } else {
                    return 13;
                }
            }
            return 53;
        }
        return 7;
    }
}
