package com.tencent.mobileqq.guild.contentshare.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.contentshare.ChannelInfo;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.mobileqq.guild.contentshare.g;
import com.tencent.mobileqq.guild.contentshare.h;
import com.tencent.mobileqq.guild.contentshare.template.header.SharePicBottomLayout;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/b;", "Lcom/tencent/mobileqq/guild/contentshare/g;", "", "guildId", "", "b", "Lcom/tencent/mobileqq/guild/contentshare/template/header/SharePicBottomLayout;", "qrCodeView", "Lcom/tencent/mobileqq/guild/contentshare/c;", "channelInfo", "", "e", "Landroid/graphics/drawable/Drawable;", "c", "d", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/h;", "style", "a", "", "I", "bgResId", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int bgResId;

    public b(int i3) {
        this.bgResId = i3;
    }

    private final boolean b(String guildId) {
        ArrayList<IGProMedalInfo> medalInfoList;
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(guildId);
        if (guildInfo != null && (medalInfoList = guildInfo.getMedalInfoList()) != null) {
            Iterator<T> it = medalInfoList.iterator();
            while (it.hasNext()) {
                if (((IGProMedalInfo) it.next()).getOfficialMedalInfoExt().getIsOffical()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final Drawable c(String guildId) {
        String str;
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(guildId);
        if (guildInfo != null) {
            str = guildInfo.getAvatarUrl(100);
        } else {
            str = null;
        }
        QLog.i("SharePicBottomInfoComponent", 1, "getGuildImage avatarUrl=" + str);
        Drawable guildFaceIcon = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildFaceIcon(str, com.tencent.guild.aio.util.c.b(60), BaseImageUtil.getDefaultFaceDrawable(false), false);
        Intrinsics.checkNotNullExpressionValue(guildFaceIcon, "api(IQQGuildUtilApi::cla\u2026(), defaultAvatar, false)");
        return guildFaceIcon;
    }

    private final String d(String guildId) {
        String str;
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(guildId);
        if (guildInfo != null) {
            str = guildInfo.getGuildName();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void e(SharePicBottomLayout qrCodeView, ChannelInfo channelInfo) {
        QLog.i("SharePicBottomInfoComponent", 1, "handleQRCode shareUrl=" + channelInfo.getShareUrl());
        qrCodeView.setQRCodeUrl(channelInfo.getShareUrl());
    }

    @Override // com.tencent.mobileqq.guild.contentshare.g
    public void a(@NotNull ViewGroup parent, @NotNull d shareData, @Nullable h style) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        QLog.i("SharePicBottomInfoComponent", 1, "setContent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SharePicBottomLayout sharePicBottomLayout = new SharePicBottomLayout(context);
        sharePicBottomLayout.setBackgroundResource(this.bgResId);
        sharePicBottomLayout.setGuildName(d(shareData.getChannelInfo().getGuildId()));
        sharePicBottomLayout.setChannelDrawable(c(shareData.getChannelInfo().getGuildId()));
        sharePicBottomLayout.g(b(shareData.getChannelInfo().getGuildId()));
        parent.addView(sharePicBottomLayout);
        e(sharePicBottomLayout, shareData.getChannelInfo());
    }

    public /* synthetic */ b(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? R.drawable.lvj : i3);
    }
}
