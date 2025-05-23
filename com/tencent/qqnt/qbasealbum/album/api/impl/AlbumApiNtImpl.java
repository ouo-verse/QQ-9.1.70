package com.tencent.qqnt.qbasealbum.album.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.album.api.IAlbumApi;
import com.tencent.qqnt.qbasealbum.album.fragment.QAlbumModeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/api/impl/AlbumApiNtImpl;", "Lcom/tencent/qqnt/qbasealbum/album/api/IAlbumApi;", "()V", "isCurrentModelSupport", "", "startQAlbumModeFragment", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "hideSettingText", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AlbumApiNtImpl implements IAlbumApi {
    static IPatchRedirector $redirector_;

    public AlbumApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.album.api.IAlbumApi
    public boolean isCurrentModelSupport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.qbasealbum.album.api.IAlbumApi
    public void startQAlbumModeFragment(@NotNull Activity activity, boolean hideSettingText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, Boolean.valueOf(hideSettingText));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        intent.putExtra("hide_setting_text", hideSettingText);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.f243621a);
        CompatPublicActivity.start(activity, intent, QAlbumModeFragment.class);
    }
}
