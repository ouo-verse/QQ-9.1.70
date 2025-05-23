package com.tencent.mobileqq.guild.feed.presenter;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/presenter/l;", "", "", "pageSource", "", "a", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f222834a = new l();

    l() {
    }

    @JvmStatic
    @NotNull
    public static final String a(int pageSource) {
        if (pageSource != 3 && pageSource != 4) {
            if (pageSource != 5) {
                if (pageSource != 6) {
                    return "";
                }
                return "1";
            }
            return "2";
        }
        return "3";
    }

    @JvmStatic
    @NotNull
    public static final String b(int pageSource) {
        if (pageSource != 1) {
            if (pageSource != 2) {
                switch (pageSource) {
                    case 11:
                        return "pg_sgrp_discover_hot_content";
                    case 12:
                        return "pg_sgrp_public_accounts_hot_native";
                    case 13:
                        return "pg_sgrp_discover_shallow";
                    default:
                        return "pg_sgrp_forum";
                }
            }
            return "pg_sgrp_public_accounts_mine_native";
        }
        return "pg_sgrp_discover_mine";
    }
}
