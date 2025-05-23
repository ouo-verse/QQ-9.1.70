package com.tencent.qqnt.qbasealbum.album.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.studymode.g;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.album.api.IAlbumApi;
import com.tencent.qqnt.qbasealbum.album.fragment.QAlbumModeFragment;
import com.tencent.richframework.gallery.QQGalleryActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/api/impl/AlbumApiImpl;", "Lcom/tencent/qqnt/qbasealbum/album/api/IAlbumApi;", "()V", "isCurrentModelSupport", "", "startQAlbumModeFragment", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "hideSettingText", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AlbumApiImpl implements IAlbumApi {
    @Override // com.tencent.qqnt.qbasealbum.album.api.IAlbumApi
    public boolean isCurrentModelSupport() {
        int a16 = g.a();
        return a16 == 0 || a16 == 2;
    }

    @Override // com.tencent.qqnt.qbasealbum.album.api.IAlbumApi
    public void startQAlbumModeFragment(Activity activity, boolean hideSettingText) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        intent.putExtra("hide_setting_text", hideSettingText);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.f243621a);
        CompatPublicActivity.Launcher.start(intent, QQGalleryActivity.class, QAlbumModeFragment.class);
    }
}
