package com.tencent.mobileqq.guild.feed.gallery.part;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/e;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "", "A9", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "z9", "initPageBean", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "action", "", "args", "handleBroadcastMessage", "Lgh1/b;", "d", "Lgh1/b;", "exposeHelper", "e", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends com.tencent.mobileqq.guild.feed.part.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private gh1.b exposeHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean initBean;

    private final void A9() {
        String str;
        int immersiveSource = z9().getImmersiveSource();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild_Feed_GAL_GuildFeedGalleryExposeP", "[initExpose] pageInSource:" + immersiveSource);
        }
        boolean z16 = true;
        if (immersiveSource != 1 && immersiveSource != 4) {
            if (immersiveSource != 19) {
                switch (immersiveSource) {
                    case 7:
                    case 8:
                        break;
                    case 9:
                    case 10:
                        str = "oa_feeds";
                        break;
                    default:
                        str = "";
                        break;
                }
            }
            str = "discover_feeds";
        } else {
            str = "guild_feeds";
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        gh1.b bVar = new gh1.b(str);
        this.exposeHelper = bVar;
        bVar.k();
        broadcastMessage("init_expose", this.exposeHelper);
    }

    private final void B9() {
        String str;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
            if (guildFeedGalleryInitBean != null) {
                str = guildFeedGalleryInitBean.getFeedId();
            } else {
                str = null;
            }
            Log.d("Guild_Feed_GAL_GuildFeedGalleryExposeP", "[updateInitBean] initBean.feedId=" + str);
        }
        initPageBean();
    }

    private final void initPageBean() {
        GuildFeedBaseInitBean o16 = ax.o(getHostFragment());
        if (o16 instanceof GuildFeedGalleryInitBean) {
            this.initBean = (GuildFeedGalleryInitBean) o16;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild_Feed_GAL_GuildFeedGalleryExposeP", "[initPageBean] getInitBeanSuccess:" + this.initBean);
            }
        }
    }

    private final GuildFeedGalleryInitBean z9() {
        if (this.initBean == null) {
            initPageBean();
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        return guildFeedGalleryInitBean;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@NotNull String action, @Nullable Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "message_on_init_bean_changed")) {
            B9();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        A9();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        gh1.b bVar = this.exposeHelper;
        if (bVar != null) {
            bVar.m();
        }
    }
}
