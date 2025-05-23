package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryPreloadEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes13.dex */
public class GuildFeedGalleryPreloadPart extends d {

    /* renamed from: d, reason: collision with root package name */
    private GuildFeedGalleryInitBean f222435d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f222436e = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f222437f = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f222441e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z16, String str) {
            super(z16);
            this.f222441e = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedGalleryPreloadPart", 1, "preloadThumb " + loadState);
            }
            Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                QLog.d("GuildFeedGalleryPreloadPart", 1, "save bitmap to global image cache, key: " + this.f222441e);
                GuildFeedGalleryPreloadPart.J9(com.tencent.mobileqq.guild.picload.e.d(this.f222441e), resultBitMap);
                GuildFeedGalleryPreloadPart.this.f222436e.add(this.f222441e);
            }
        }
    }

    public static String C9(String str) {
        return "guild_gallery_" + str;
    }

    public static Bitmap D9(String str) {
        Bitmap f16;
        if (TextUtils.isEmpty(str) || (f16 = ImageCacheHelper.f98636a.f(C9(str))) == null || f16.isRecycled()) {
            return null;
        }
        return f16;
    }

    private GuildFeedRichMediaData E9(int i3) {
        List<GuildFeedRichMediaData> richMediaDataList = this.f222435d.getRichMediaDataList();
        if (richMediaDataList == null || richMediaDataList.isEmpty() || i3 < 0 || i3 >= richMediaDataList.size()) {
            return null;
        }
        GuildFeedRichMediaData guildFeedRichMediaData = richMediaDataList.get(i3);
        if (guildFeedRichMediaData.getImage() == null) {
            return null;
        }
        return guildFeedRichMediaData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F9(GuildFeedRichMediaData guildFeedRichMediaData) {
        if (guildFeedRichMediaData.getImage().isGif) {
            String d16 = bm.d(guildFeedRichMediaData);
            String m3 = bm.m(guildFeedRichMediaData.getImage());
            if (!TextUtils.isEmpty(d16) && d16.equals(m3)) {
                return false;
            }
            return true;
        }
        return true;
    }

    private void G9(final int i3) {
        final GuildFeedRichMediaData E9 = E9(i3);
        if (E9 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("GuildFeedGalleryPreloadPart", 1, "mediaData is null " + i3);
                return;
            }
            return;
        }
        final String m3 = bm.m(E9.getImage());
        if (!URLUtil.isNetworkUrl(m3)) {
            QLog.e("GuildFeedGalleryPreloadPart", 1, "pos:" + i3 + ", thumbnailUrl is not network url " + m3);
            return;
        }
        if (D9(com.tencent.mobileqq.guild.picload.e.d(m3)) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedGalleryPreloadPart", 1, "pos:" + i3 + ", Bitmap From Cache exit, key: " + m3);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedGalleryPreloadPart", 1, "pos:" + i3 + ", start preloadThumb url " + m3);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryPreloadPart.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuildFeedGalleryPreloadPart.this.F9(E9)) {
                    GuildFeedGalleryPreloadPart.this.I9(m3);
                    if (E9.getImage().isGif) {
                        GuildFeedGalleryPreloadPart.this.H9(bm.d(E9));
                        return;
                    }
                    return;
                }
                QLog.e("GuildFeedGalleryPreloadPart", 1, "don't need preload thumbnail, pos: " + i3 + ", url: " + m3);
            }
        }, 192, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9(String str) {
        if (this.f222437f.contains(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedGalleryPreloadPart", 1, "gif url has already preload, key: " + str);
                return;
            }
            return;
        }
        this.f222437f.add(str);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        try {
            URLDrawable.getDrawable(str, obtain);
        } catch (Exception e16) {
            QLog.e("GuildFeedGalleryPreloadPart", 1, "preloadGif get exception!", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9(String str) {
        if (D9(com.tencent.mobileqq.guild.picload.e.d(str)) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedGalleryPreloadPart", 1, "url has already cache! key: " + str);
                return;
            }
            return;
        }
        if (this.f222436e.contains(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedGalleryPreloadPart", 1, "url has already preload, key: " + str);
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(str), new a(true, str));
    }

    public static void J9(String str, Bitmap bitmap) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            ImageCacheHelper.f98636a.i(C9(str), bitmap, Business.Guild);
        }
    }

    public static void K9(String str, Bitmap bitmap, Priority priority) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            ImageCacheHelper.f98636a.k(C9(str), bitmap, Business.Guild, priority, null);
        }
    }

    private void initPageBean() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (!(serializableExtra instanceof GuildFeedGalleryInitBean)) {
                return;
            }
            this.f222435d = (GuildFeedGalleryInitBean) serializableExtra;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildFeedGalleryPreloadEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedGalleryPreloadPart";
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        initPageBean();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.f222435d;
        if (guildFeedGalleryInitBean == null) {
            return;
        }
        int enterPos = guildFeedGalleryInitBean.getEnterPos();
        G9(enterPos);
        G9(enterPos - 1);
        G9(enterPos + 1);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f222436e.clear();
        this.f222437f.clear();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedGalleryPreloadEvent) {
            int curPos = ((GuildFeedGalleryPreloadEvent) simpleBaseEvent).getCurPos();
            G9(curPos - 1);
            G9(curPos + 1);
        }
    }
}
