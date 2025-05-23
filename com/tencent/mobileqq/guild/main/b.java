package com.tencent.mobileqq.guild.main;

import android.content.res.Resources;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/main/b;", "", "", "appId", "", "b", "Landroid/view/View;", "itemView", "", "resId", "", "c", "memberCount", "memberMaxCount", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f227101a = new b();

    b() {
    }

    @JvmStatic
    @NotNull
    public static final String a(int memberCount, int memberMaxCount) {
        boolean z16;
        boolean z17;
        boolean z18;
        String valueOf;
        int roundToInt;
        boolean z19;
        boolean z26;
        String valueOf2;
        int roundToInt2;
        boolean z27 = false;
        if (1 <= memberMaxCount && memberMaxCount < 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            valueOf = String.valueOf(memberMaxCount);
        } else {
            if (1000 <= memberMaxCount && memberMaxCount < 9901) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                valueOf = (((float) Math.ceil(memberMaxCount / 100.0f)) / 10.0d) + "k";
            } else {
                if (9901 <= memberMaxCount && memberMaxCount < 100000) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    roundToInt = MathKt__MathJVMKt.roundToInt((float) Math.ceil(memberMaxCount / 1000.0f));
                    valueOf = roundToInt + "k";
                } else {
                    valueOf = String.valueOf(memberMaxCount);
                }
            }
        }
        if (memberCount == memberMaxCount) {
            valueOf2 = valueOf;
        } else {
            if (1 <= memberCount && memberCount < 1000) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                valueOf2 = String.valueOf(memberCount);
            } else {
                if (1000 <= memberCount && memberCount < 10000) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    valueOf2 = (((float) Math.floor(memberCount / 100.0f)) / 10.0d) + "k";
                } else {
                    if (10000 <= memberCount && memberCount < 100000) {
                        z27 = true;
                    }
                    if (z27) {
                        roundToInt2 = MathKt__MathJVMKt.roundToInt((float) Math.floor(memberCount / 1000.0f));
                        valueOf2 = roundToInt2 + "k";
                    } else {
                        valueOf2 = String.valueOf(memberCount);
                    }
                }
            }
        }
        return valueOf2 + "/" + valueOf;
    }

    @JvmStatic
    public static final boolean b(long appId) {
        if (appId >= 1010000 && appId < 1020000) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void c(@NotNull View itemView, int resId) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Resources resources = itemView.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "itemView.context.resources");
        Resources.Theme theme = itemView.getContext().getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "itemView.context.theme");
        ViewCompat.setBackground(itemView, ResourcesCompat.getDrawable(resources, resId, theme));
    }
}
