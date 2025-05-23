package com.tencent.mobileqq.emoticon.api.impl;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.api.IAIOEmoticonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/AIOEmoticonUtilsImpl;", "Lcom/tencent/mobileqq/emoticon/api/IAIOEmoticonUtils;", "()V", "getAlbumBg", "Landroid/graphics/drawable/Drawable;", DKConfiguration.Directory.RESOURCES, "Landroid/content/res/Resources;", "getAlbumPressBg", "getAlbumRightArrow", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class AIOEmoticonUtilsImpl implements IAIOEmoticonUtils {
    static IPatchRedirector $redirector_;

    public AIOEmoticonUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IAIOEmoticonUtils
    @Nullable
    public Drawable getAlbumBg(@NotNull Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resources);
        }
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getDrawable(R.drawable.qui_common_fill_standard_primary_bg);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IAIOEmoticonUtils
    @Nullable
    public Drawable getAlbumPressBg(@NotNull Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resources);
        }
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getDrawable(R.drawable.qui_common_fill_light_primary_pressed_bg);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IAIOEmoticonUtils
    @Nullable
    public Drawable getAlbumRightArrow(@NotNull Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources);
        }
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getDrawable(R.drawable.qui_aio_emotion_album_right_arrow);
    }
}
