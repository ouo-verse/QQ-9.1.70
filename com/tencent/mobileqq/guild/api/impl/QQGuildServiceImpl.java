package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import vh2.bv;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildServiceImpl implements IQQGuildService {
    private static final String TAG = "QQGuildServiceImpl";
    private HashMap<String, List<String>> mCollapseGuildMap = new HashMap<>();
    private Set<IQQGuildService.a> mDiscoverObservers = new HashSet();
    private RuntimeServiceHolder mServiceHolder;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements vh2.s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f214412a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f214413b;

        a(ImageView imageView, Drawable drawable) {
            this.f214412a = imageView;
            this.f214413b = drawable;
        }

        @Override // vh2.s
        public void a(int i3, String str, IGProGuildInfo iGProGuildInfo, List<cy> list) {
            if (i3 == 0 && iGProGuildInfo != null) {
                com.tencent.mobileqq.guild.util.v.k(iGProGuildInfo.getAvatarUrl(100), this.f214412a, this.f214413b);
                return;
            }
            QLog.e(QQGuildServiceImpl.TAG, 1, "fetchGuestGuild code:" + i3 + " msg:" + str + " info:" + iGProGuildInfo);
            this.f214412a.setImageDrawable(this.f214413b);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void addDiscoverObserver(IQQGuildService.a aVar) {
        this.mDiscoverObservers.add(aVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void addGuild(Context context, JumpGuildParam jumpGuildParam, String str, bv bvVar) {
        com.tencent.mobileqq.guild.channel.joinchannel.h.a(context, jumpGuildParam, new JoinGuildLogic.JumpParam(), str, bvVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void addRedDragListener(IQQGuildService.b bVar) {
        GuildMainFrameRedDragManager.i().e(bVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public Drawable getAvatarDrawable(String str) {
        Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = defaultFaceDrawable;
        obtain.mFailedDrawable = defaultFaceDrawable;
        DownloadParams.DecodeHandler decodeHandler = ch.f235510c;
        obtain.mMemoryCacheKeySuffix = String.valueOf(System.identityHashCode(decodeHandler));
        try {
            IGProGuildInfo guildInfo = ((IGPSService) this.mServiceHolder.d(IGPSService.class)).getGuildInfo(str);
            if (guildInfo != null && guildInfo.getAvatarUrl(0) != null) {
                URLDrawable drawable = URLDrawable.getDrawable(guildInfo.getAvatarUrl(0), obtain);
                int dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cdd);
                drawable.setTag(new int[]{dimensionPixelSize, dimensionPixelSize});
                drawable.setDecodeHandler(decodeHandler);
                return drawable;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return defaultFaceDrawable;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public boolean isCategoryCollapse(String str, String str2) {
        List<String> list;
        if (!TextUtils.isEmpty(str2) && (list = this.mCollapseGuildMap.get(str)) != null && list.size() != 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str2.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public boolean isCurrentGuildManager(AppInterface appInterface, String str) {
        return ch.t0(((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(str));
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public boolean isWhiteUser() {
        return ch.E0();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mServiceHolder = new RuntimeServiceHolder();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mCollapseGuildMap.clear();
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void removeRedDragListener(IQQGuildService.b bVar) {
        GuildMainFrameRedDragManager.i().l(bVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void removerDisObserver(IQQGuildService.a aVar) {
        this.mDiscoverObservers.remove(aVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void setAvatarDrawableForGuest(String str, ImageView imageView) {
        if (imageView == null) {
            QLog.e(TAG, 1, "setAvatarDrawableForGuest imageView is null " + str);
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(QQGuildUIUtil.j(false));
        IGProGuildInfo guildInfo = ((IGPSService) this.mServiceHolder.d(IGPSService.class)).getGuildInfo(str);
        if (guildInfo != null) {
            com.tencent.mobileqq.guild.util.v.k(guildInfo.getAvatarUrl(100), imageView, bitmapDrawable);
        } else {
            ((IGPSService) ch.R0(IGPSService.class)).fetchGuestGuild(str, false, new a(imageView, bitmapDrawable));
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void setCategoryCollapse(String str, String str2, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, String.format("setCategoryCollapse guildId=%s, categoryName=%s, isCollapse=%b", str, str2, Boolean.valueOf(z16)));
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.mCollapseGuildMap.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        Iterator<String> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (str2.equals(it.next())) {
                it.remove();
                break;
            }
        }
        if (z16) {
            list.add(str2);
        }
        this.mCollapseGuildMap.put(str, list);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public void updateDiscoverRed(int i3) {
        Iterator<IQQGuildService.a> it = this.mDiscoverObservers.iterator();
        while (it.hasNext()) {
            it.next().a(i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService
    public Drawable getAvatarDrawable(String str, int i3, String str2, boolean z16) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(QQGuildUIUtil.j(z16));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = bitmapDrawable;
        obtain.mFailedDrawable = bitmapDrawable;
        if (z16 && TextUtils.isEmpty(str2)) {
            obtain.mMemoryCacheKeySuffix = String.valueOf(System.identityHashCode(ch.f235510c));
        } else {
            obtain.mMemoryCacheKeySuffix = str2;
        }
        try {
            IGProGuildInfo guildInfo = ((IGPSService) this.mServiceHolder.d(IGPSService.class)).getGuildInfo(str);
            if (guildInfo != null && !TextUtils.isEmpty(guildInfo.getAvatarUrl(i3))) {
                URLDrawable drawable = URLDrawable.getDrawable(guildInfo.getAvatarUrl(i3), obtain);
                drawable.setTag(new int[]{i3, i3});
                if (z16) {
                    drawable.setDecodeHandler(ch.f235510c);
                }
                return drawable;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return bitmapDrawable;
    }
}
