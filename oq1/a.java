package oq1;

import android.view.LayoutInflater;
import android.view.View;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.gift.module.d;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.guild.gift.view.banner.e;
import com.tencent.mobileqq.guild.gift.view.banner.f;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.NotifyReceivePayGiftChanged;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0006B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0004H\u0016R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Loq1/a;", "Lcom/tencent/mobileqq/guild/gift/module/m;", "Lcom/tencent/mobileqq/guild/gift/view/banner/f;", "Lcom/tencent/mobileqq/guild/gift/module/k;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "", "a", "g", "giftAnimData", "b", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "c", "f", "d", "contentView", "of", "t", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "R7", "data", "", "isFromPack", HippyTKDListViewAdapter.X, "originalData", "e", "Ltq1/b;", "Ltq1/b;", "liveRoomUiData", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lcom/tencent/mobileqq/guild/gift/view/banner/e;", "Lcom/tencent/mobileqq/guild/gift/view/banner/e;", "giftBanner", h.F, "Landroid/view/View;", "view", "<init>", "(Ltq1/b;Lcom/tencent/mobileqq/app/QBaseFragment;)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements m, f, k<GiftMessage> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final tq1.b liveRoomUiData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseFragment fragment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e giftBanner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View view;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"oq1/a$b", "Lcom/tencent/mobileqq/guild/gift/module/d;", "", "success", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "pngFilePath", "apngFilePath", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f423382a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f423383b;

        b(d dVar, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            this.f423382a = dVar;
            this.f423383b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftAnimData, String str) {
            Intrinsics.checkNotNullParameter(giftAnimData, "$giftAnimData");
            j.d().i(new com.tencent.mobileqq.guild.media.core.notify.m(giftAnimData, str));
        }

        @Override // com.tencent.mobileqq.guild.gift.module.d
        public void a(boolean success, int materialId, @Nullable final String pngFilePath, @Nullable String apngFilePath) {
            this.f423382a.a(success, materialId, pngFilePath, apngFilePath);
            final com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f423383b;
            Function0.b(1000, new Runnable() { // from class: oq1.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.c(com.tencent.mobileqq.qqgift.mvvm.business.anim.a.this, pngFilePath);
                }
            });
        }
    }

    public a(@NotNull tq1.b liveRoomUiData, @NotNull QBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(liveRoomUiData, "liveRoomUiData");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.liveRoomUiData = liveRoomUiData;
        this.fragment = fragment;
        this.giftBanner = com.tencent.mobileqq.guild.gift.view.banner.a.f224618a.a(this);
    }

    private final void b(GiftMessage giftAnimData) {
        if (!this.liveRoomUiData.N()) {
            QLog.w("GuildLiveGiftBannerManager", 1, "warn handleLiveChargeGift is not myself receiver id: " + giftAnimData.receiver);
            return;
        }
        com.tencent.mobileqq.guild.media.core.logic.gift.e eVar = com.tencent.mobileqq.guild.media.core.logic.gift.e.f228473a;
        if (eVar.e()) {
            eVar.i(NetConnInfoCenter.getServerTimeMillis());
            this.liveRoomUiData.B().setValue(new NotifyReceivePayGiftChanged(null, null, 3, null));
        }
    }

    private final void g() {
        GLiveChannelCore.f226698a.i().e(this);
    }

    @Override // com.tencent.mobileqq.guild.gift.view.banner.f
    public void R7(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftAnimData, @NotNull d callback) {
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GLiveChannelCore.f226698a.i().a(giftAnimData.f264914e, new b(callback, giftAnimData));
    }

    @NotNull
    public final View c(@NotNull LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View a16 = this.giftBanner.a(inflater);
        this.view = a16;
        Intrinsics.checkNotNull(a16);
        return a16;
    }

    public final void d() {
        this.giftBanner.onDestroy();
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        gLiveChannelCore.i().g(this);
        gLiveChannelCore.i().f(this);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void I(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, @NotNull GiftMessage originalData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        this.giftBanner.c(data);
        b(originalData);
    }

    public final void f() {
        a();
        g();
        GLiveChannelCore.f226698a.i().h(this);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void o() {
        k.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.m
    public void of(@NotNull View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void s(int i3, @Nullable String str) {
        k.a.b(this, i3, str);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void x(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, boolean isFromPack) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    private final void a() {
    }

    @Override // com.tencent.mobileqq.guild.gift.module.m
    public void t() {
    }
}
