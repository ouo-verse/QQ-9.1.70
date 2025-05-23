package l02;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.share.g;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.e;
import com.tencent.mobileqq.sharepanel.f;
import com.tencent.mobileqq.sharepanel.j;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0006B/\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\b\b\u0001\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Ll02/d;", "", "", "d", "e", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "Ljava/lang/String;", ThirdPartyMiniPageProxy.KEY_SHARE_TEXT, "c", "guildId", "channelId", "Lcom/tencent/mobileqq/sharepanel/f;", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "Ll02/a;", "f", "Ll02/a;", "executor", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "g", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String shareText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f sharePanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a executor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"l02/d$b", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements n {
        b() {
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull m callback) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", -1);
            bundle.putString(AppConstants.Key.FORWARD_TEXT, d.this.shareText);
            Intent intent = new Intent();
            intent.putExtra("isFromShare", true);
            intent.putExtras(bundle);
            callback.a(intent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"l02/d$c", "Lcom/tencent/mobileqq/sharepanel/e;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "contact", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements e {
        c() {
        }

        @Override // com.tencent.mobileqq.sharepanel.e
        public boolean a(@NotNull ResultRecord contact) {
            Intrinsics.checkNotNullParameter(contact, "contact");
            int i3 = contact.uinType;
            if (i3 == 0 || i3 == 1) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"l02/d$d", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l02.d$d, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C10698d implements j {
        C10698d() {
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            int hashCode = channelId.hashCode();
            if (hashCode != -791575966) {
                if (hashCode != -393543490) {
                    if (hashCode == 3367071 && channelId.equals("mypc")) {
                        d.this.d();
                        return;
                    }
                    return;
                }
                if (channelId.equals("qqfriend")) {
                    d.this.executor.a();
                    return;
                }
                return;
            }
            if (channelId.equals("weixin")) {
                d.this.executor.c();
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
        }
    }

    public d(@NonNull @NotNull FragmentActivity activity, @NonNull @NotNull String shareText, @NonNull @NotNull String guildId, @NonNull @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareText, "shareText");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.activity = activity;
        this.shareText = shareText;
        this.guildId = guildId;
        this.channelId = channelId;
        this.sharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(activity, "pindao_livepush");
        this.executor = new a(activity, shareText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        BaseQQAppInterface baseQQAppInterface;
        String str;
        int i3;
        AppInterface l3 = ch.l();
        if (l3 instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) l3;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        boolean p16 = h.p(baseQQAppInterface);
        if (p16) {
            str = h.g(baseQQAppInterface);
        } else {
            str = AppConstants.DATALINE_PC_UIN;
        }
        if (p16) {
            i3 = 0;
        } else {
            i3 = 6000;
        }
        this.executor.b(str, i3);
    }

    public final void e() {
        f fVar = this.sharePanel;
        String string = this.activity.getString(R.string.f156741l1);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.guild_share_to)");
        fVar.setTitle(string);
        this.sharePanel.k0(new b());
        this.sharePanel.g0(new c());
        this.sharePanel.l0("weixin", m02.d.i());
        this.sharePanel.d0(new g(this.activity, GuildSharePageSource.LIVE_CHANNEL, this.guildId, this.channelId).b());
        this.sharePanel.t0(new C10698d());
        this.sharePanel.show();
    }
}
