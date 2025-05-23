package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/GuildTroopApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IGuildTroopApi;", "()V", "fetchGuildTroopTitleData", "", "", "", "getAvatarDrawable", "Landroid/graphics/drawable/Drawable;", "url", "width", "", "height", "getFeedFragment", "Landroidx/fragment/app/Fragment;", "troopUin", "getLoadingView", "Landroid/view/View;", "context", "Landroid/content/Context;", "isGuildTroop", "", "isNeedHideTroopGuildEntrance", "startLoadingAnim", "", "view", "stopLoadingAnim", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class GuildTroopApiNtImpl implements IGuildTroopApi {
    static IPatchRedirector $redirector_;

    public GuildTroopApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    @NotNull
    public Map<String, Object> fetchGuildTroopTitleData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.TRUE;
        hashMap.put("showRedDot", bool);
        hashMap.put("visiable", bool);
        hashMap.put("msgTab_unselectRes", Integer.valueOf(R.drawable.qui_message_selector));
        hashMap.put("msgTab_selectRes", Integer.valueOf(R.drawable.qui_message_selector));
        hashMap.put("feedTab_unselectRes", Integer.valueOf(R.drawable.qui_tiezi));
        hashMap.put("feedTab_selectRes", Integer.valueOf(R.drawable.qui_tiezi));
        return hashMap;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    @Nullable
    public Drawable getAvatarDrawable(@NotNull String url, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, this, url, Integer.valueOf(width), Integer.valueOf(height));
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    @Nullable
    public Fragment getFeedFragment(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Fragment) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    @Nullable
    public View getLoadingView(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public boolean isGuildTroop(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public boolean isNeedHideTroopGuildEntrance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public void startLoadingAnim(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public void stopLoadingAnim(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }
}
