package com.tencent.mobileqq.guild.util.security;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\b\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0003\u00a8\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "errorCode", "", "errorMsg", "defaultErrorMsg", "", "c", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {
    @Deprecated(message = "\u9519\u8bef\u7801\u4e0e\u6587\u6848\u6620\u5c04\uff0c\u540e\u7eed\u7b49\u5168\u90e8\u90fd\u4f7f\u7528\u540e\u53f0\u8fd4\u56de\u6587\u6848\u540e\u5c31\u4e0d\u9700\u8981\u8fd9\u4e2a\u8f6c\u6362\u4e86")
    private static final String b(Context context, int i3) {
        if (i3 != 10011) {
            if (i3 != 22005) {
                if (i3 != 29001) {
                    if (i3 != 30006) {
                        if (i3 != 54006) {
                            if (i3 != 22000) {
                                if (i3 != 22001) {
                                    return null;
                                }
                                return context.getResources().getString(R.string.f138630_3);
                            }
                            return context.getResources().getString(R.string.f138640_4);
                        }
                        return context.getResources().getString(R.string.f146240tn);
                    }
                    return context.getResources().getString(R.string.f1519018y);
                }
                return context.getResources().getString(R.string.f141320gc);
            }
            return context.getResources().getString(R.string.f138620_2);
        }
        return context.getResources().getString(R.string.f15193191);
    }

    @JvmOverloads
    public static final void c(@Nullable Context context, int i3, @Nullable String str, @Nullable String str2) {
        boolean z16;
        if (context == null) {
            return;
        }
        if (i3 == 29100 || i3 == 29101) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                DialogUtil.createCustomDialog(context, 230, (String) null, str, (String) null, context.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.security.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        b.e(dialogInterface, i16);
                    }
                }, (DialogInterface.OnClickListener) null).show();
                return;
            }
        }
        QQToast.makeText(context, 1, cb.d(str, b(context, i3), str2, context.getResources().getString(R.string.f141910hy)), 1).show();
    }

    public static /* synthetic */ void d(Context context, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str2 = null;
        }
        c(context, i3, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DialogInterface dialogInterface, int i3) {
    }
}
