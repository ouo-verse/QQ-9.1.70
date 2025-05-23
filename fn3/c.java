package fn3;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002\u001a\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Landroid/content/Context;", "context", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "d", "busyType", "c", "bizType", "f", "g", "a", "pkType", "b", h.F, "e", "qq-live-link-pk-anchorplay-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {
    @NotNull
    public static final String a(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    String string = context.getString(R.string.f169978yj3, "PK");
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ept_invite_btn_text,\"PK\")");
                    return string;
                }
                return "\u63a5\u53d7";
            }
            String string2 = context.getString(R.string.f169978yj3, "PK");
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026pt_invite_btn_text, \"PK\")");
            return string2;
        }
        String string3 = context.getString(R.string.f169978yj3, "\u8fde\u9ea6");
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026pt_invite_btn_text, \"\u8fde\u9ea6\")");
        return string3;
    }

    @NotNull
    public static final String b(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 != 1) {
            if (i3 != 2) {
                String string = context.getString(R.string.zr_);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026og_in_rank_link_pk_title)");
                return string;
            }
            String string2 = context.getString(R.string.zr_);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026og_in_rank_link_pk_title)");
            return string2;
        }
        String string3 = context.getString(R.string.zra);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026_in_rank_normal_pk_title)");
        return string3;
    }

    @NotNull
    public static final String c(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 == 5) {
            String string = context.getString(R.string.zri, d(context, i3));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ptText(context,busyType))");
            return string;
        }
        String string2 = context.getString(R.string.zrb, d(context, i3));
        Intrinsics.checkNotNullExpressionValue(string2, "{\n        context.getStr\u2026(context,busyType))\n    }");
        return string2;
    }

    @NotNull
    public static final String d(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        String string = context.getString(R.string.f161351xh);
                        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.invite_type_link_pk)");
                        return string;
                    }
                    String string2 = context.getString(R.string.f158891qu);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.hint_string_pk)");
                    return string2;
                }
                String string3 = context.getString(R.string.f158911qw);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.hint_string_restart_pk)");
                return string3;
            }
            String string4 = context.getString(R.string.f161351xh);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.invite_type_link_pk)");
            return string4;
        }
        String string5 = context.getString(R.string.f161341xg);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.invite_type_link)");
        return string5;
    }

    @NotNull
    public static final String e(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 5) {
                    String string = context.getString(R.string.zgj);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.bubble_invite_link_pk)");
                    return string;
                }
                String string2 = context.getString(R.string.zgl);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.bubble_invite_rank_pk)");
                return string2;
            }
            String string3 = context.getString(R.string.zgj);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.bubble_invite_link_pk)");
            return string3;
        }
        String string4 = context.getString(R.string.zgk);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026ubble_invite_link_screen)");
        return string4;
    }

    @NotNull
    public static final String f(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        String string = context.getString(R.string.zrk);
                        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_receive_pk_invite_title)");
                        return string;
                    }
                    String string2 = context.getString(R.string.zrl);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026ive_rank_pk_invite_title)");
                    return string2;
                }
                String string3 = context.getString(R.string.zrm);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026_restart_pk_invite_title)");
                return string3;
            }
            String string4 = context.getString(R.string.zrk);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026_receive_pk_invite_title)");
            return string4;
        }
        String string5 = context.getString(R.string.zrj);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026eceive_link_invite_title)");
        return string5;
    }

    @NotNull
    public static final String g(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 != 4) {
            if (i3 != 5) {
                String string = context.getString(R.string.f161321xe, d(context, i3));
                Intrinsics.checkNotNullExpressionValue(string, "{\n        context.getStr\u2026(context,busyType))\n    }");
                return string;
            }
            String string2 = context.getString(R.string.f161321xe, context.getString(R.string.f158901qv));
            Intrinsics.checkNotNullExpressionValue(string2, "{\n        context.getStr\u2026nt_string_rank_pk))\n    }");
            return string2;
        }
        String string3 = context.getString(R.string.f161311xd);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026e_refuse_restart_pk_tips)");
        return string3;
    }

    @NotNull
    public static final String h(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i3 != 1) {
            if (i3 != 3) {
                String string = context.getString(R.string.f224296ij, context.getString(R.string.f158891qu));
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026R.string.hint_string_pk))");
                return string;
            }
            String string2 = context.getString(R.string.f224296ij, context.getString(R.string.f158891qu));
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026R.string.hint_string_pk))");
            return string2;
        }
        String string3 = context.getString(R.string.f224296ij, context.getString(R.string.f158881qt));
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026string.hint_string_link))");
        return string3;
    }
}
