package lq0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.viewpager.widget.ViewPager;
import com.tencent.guild.aio.panel.plus.subitem.GuildPagerRadioGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelFeature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lq0.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0011B!\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\b\b\u0002\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&JF\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007H\u0002J<\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 \u00a8\u0006'"}, d2 = {"Llq0/e;", "Llq0/i;", "", "guildId", "channelId", "", "fromCacheOnly", "Landroidx/core/util/Consumer;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;", "consumer", "Ljava/util/ArrayList;", "Llq0/f;", "Lkotlin/collections/ArrayList;", "f", "e", "Llq0/g;", "a", "Landroid/content/Context;", "context", "Llq0/h;", "d", "Lmq0/i;", "c", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Llq0/c$a;", "b", "", "Lmq0/e;", "[Lmq0/e;", "mAppInfoArr", "mDefaultEntities", "", "mUinType", "<init>", "([Lmq0/e;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final mq0.e[] mAppInfoArr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final mq0.e[] mDefaultEntities;

    public e(@NotNull mq0.e[] mAppInfoArr, int i3) {
        Intrinsics.checkNotNullParameter(mAppInfoArr, "mAppInfoArr");
        this.mAppInfoArr = mAppInfoArr;
        this.mDefaultEntities = new mq0.e[]{new mq0.c(i3), new mq0.a(i3), new mq0.f(i3), new mq0.b(i3), new mq0.d(i3)};
    }

    private final ArrayList<f> f(String guildId, String channelId, boolean fromCacheOnly, Consumer<List<GProGuildRobotPlusPanelFeature>> consumer) {
        ArrayList<f> arrayList = new ArrayList<>();
        QLog.d("GuildPlusPanel", 1, "getRobotServiceItemList");
        List<GProGuildRobotPlusPanelFeature> a16 = ap0.e.INSTANCE.a();
        if (a16 != null) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                arrayList.add(new mq0.g((GProGuildRobotPlusPanelFeature) it.next(), 1));
            }
        }
        new ap0.e().g(guildId, channelId, fromCacheOnly, consumer);
        return arrayList;
    }

    @Override // lq0.i
    @NotNull
    public g a() {
        g gVar = new g();
        gVar.f(20);
        gVar.e(8);
        gVar.d(4);
        return gVar;
    }

    @Override // lq0.i
    @NotNull
    public c.a b(@NotNull LayoutInflater inflater, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = inflater.inflate(R.layout.f168028ef0, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        c.a aVar = new c.a(view);
        View findViewById = view.findViewById(R.id.textView1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.textView1)");
        aVar.s((TextView) findViewById);
        View findViewById2 = view.findViewById(R.id.dcf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.imageView1)");
        aVar.r((URLImageView) findViewById2);
        View findViewById3 = view.findViewById(R.id.flag_new);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.flag_new)");
        aVar.q((ImageView) findViewById3);
        View findViewById4 = view.findViewById(R.id.f775644p);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.robot_tag)");
        aVar.t((ImageView) findViewById4);
        return aVar;
    }

    @Override // lq0.i
    @NotNull
    public mq0.i c() {
        mq0.i iVar = new mq0.i();
        iVar.f(R.drawable.guild_aio_plus_panel_indicator);
        iVar.j(15);
        iVar.g(15);
        iVar.h(3);
        iVar.i(3);
        return iVar;
    }

    @Override // lq0.i
    @NotNull
    public h d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        h hVar = new h();
        View inflate = LayoutInflater.from(context).inflate(R.layout.eez, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ild_aio_plus_panel, null)");
        hVar.e(inflate);
        View findViewById = hVar.b().findViewById(R.id.f26080ck);
        Intrinsics.checkNotNullExpressionValue(findViewById, "info.root.findViewById(R.id.plus_viewPager)");
        hVar.f((ViewPager) findViewById);
        View findViewById2 = hVar.b().findViewById(R.id.f26060ci);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "info.root.findViewById(R.id.plus_pagerGroup)");
        hVar.d((GuildPagerRadioGroup) findViewById2);
        return hVar;
    }

    @Override // lq0.i
    @NotNull
    public List<f> e(@NotNull String guildId, @NotNull String channelId, boolean fromCacheOnly, @Nullable Consumer<List<GProGuildRobotPlusPanelFeature>> consumer) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        mq0.e[] eVarArr = this.mAppInfoArr;
        if (eVarArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            eVarArr = this.mDefaultEntities;
        }
        ArrayList arrayList = new ArrayList();
        for (mq0.e eVar : eVarArr) {
            arrayList.add(eVar);
        }
        if (ap0.e.INSTANCE.b(guildId)) {
            arrayList.add(new mq0.h(1));
        }
        arrayList.addAll(f(guildId, channelId, fromCacheOnly, consumer));
        return arrayList;
    }

    public /* synthetic */ e(mq0.e[] eVarArr, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new mq0.e[0] : eVarArr, (i16 & 2) != 0 ? 1 : i3);
    }
}
