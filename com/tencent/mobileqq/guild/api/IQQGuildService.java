package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import vh2.bv;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQGuildService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void endDrag();

        void startDrag();
    }

    void addDiscoverObserver(a aVar);

    void addGuild(Context context, JumpGuildParam jumpGuildParam, String str, bv bvVar);

    void addRedDragListener(b bVar);

    Drawable getAvatarDrawable(String str);

    Drawable getAvatarDrawable(String str, int i3, String str2, boolean z16);

    boolean isCategoryCollapse(String str, String str2);

    boolean isCurrentGuildManager(AppInterface appInterface, String str);

    boolean isWhiteUser();

    void removeRedDragListener(b bVar);

    void removerDisObserver(a aVar);

    void setAvatarDrawableForGuest(String str, ImageView imageView);

    void setCategoryCollapse(String str, String str2, boolean z16);

    void updateDiscoverRed(int i3);
}
