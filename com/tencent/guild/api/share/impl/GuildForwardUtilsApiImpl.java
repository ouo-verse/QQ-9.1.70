package com.tencent.guild.api.share.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.guild.api.share.IGuildForwarder;
import com.tencent.guild.api.share.e;
import com.tencent.guild.api.share.g;
import com.tencent.guild.api.share.i;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/api/share/impl/GuildForwardUtilsApiImpl;", "Lcom/tencent/guild/api/share/IGuildForwardUtilsApi;", "Landroid/content/Intent;", "intent", "", "forwardType", "", "handleSendToGuild", "Lcom/tencent/guild/api/share/IGuildForwarder;", "getForwarder", "forwardToGuild", "Landroid/os/Bundle;", "bundle", "checkTextExceedLimit", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildForwardUtilsApiImpl implements IGuildForwardUtilsApi {

    @NotNull
    public static final String TAG = "GuildForwardUtilsApiImpl";

    private final IGuildForwarder getForwarder(int forwardType) {
        if (forwardType != 1) {
            if (forwardType != 2) {
                if (forwardType != 3) {
                    return null;
                }
                return new i();
            }
            return new e();
        }
        return new g();
    }

    private final boolean handleSendToGuild(Intent intent, int forwardType) {
        IGuildForwarder forwarder = getForwarder(forwardType);
        if (forwarder != null) {
            return forwarder.b(intent);
        }
        return false;
    }

    @Override // com.tencent.guild.api.share.IGuildForwardUtilsApi
    public boolean checkTextExceedLimit(@Nullable Bundle bundle) {
        String str;
        boolean z16;
        if (bundle != null) {
            str = bundle.getString(AppConstants.Key.FORWARD_TEXT);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || str.length() <= 1900) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.api.share.IGuildForwardUtilsApi
    public boolean forwardToGuild(@NotNull Intent intent, int forwardType) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return handleSendToGuild(intent, forwardType);
    }
}
