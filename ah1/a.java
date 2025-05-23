package ah1;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.guild.config.GuildHotSearchItem;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import tl.h;
import vp1.am;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0003\u0015\u0019\u001cB\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lah1/a;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "k", "", "isUseTokenType", "l", "", "f", h.F, "i", DomainData.DOMAIN_NAME, "g", "a", "Z", "()Z", "setUseTokenType", "(Z)V", "Landroid/view/View;", "b", "Landroid/view/View;", "mSearchTips", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "c", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "mHotSearchTips", "d", "Ljava/lang/String;", "mCurSelectTips", "Lah1/a$b;", "e", "Lah1/a$b;", "adapter", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/ViewGroup;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final String f26080g = HardCodeUtil.qqStr(R.string.f155451hj);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isUseTokenType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mSearchTips;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DownToUpViewSwitcher mHotSearchTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurSelectTips;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ah1/a$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ah1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C0036a extends ViewPager2.OnPageChangeCallback {
        C0036a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            a aVar = a.this;
            aVar.mCurSelectTips = aVar.adapter.j0(a.this.mHotSearchTips.n(position));
            Logger logger = Logger.f235387a;
            a aVar2 = a.this;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.search.GuildDisSearch-HotSearchAnimController", "onPageSelected mCurSelectTips=" + aVar2.mCurSelectTips + " position=" + position);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lah1/a$b;", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$d;", "Lah1/a$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "position", "", "j0", "holder", "", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getCenterAlign", "()Z", "m0", "(Z)V", "centerAlign", BdhLogUtil.LogTag.Tag_Conn, "isUseTokenType", "n0", "", "Lcom/tencent/mobileqq/guild/config/j;", "D", "Ljava/util/List;", "data", "<init>", "(ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends DownToUpViewSwitcher.d<d> {

        /* renamed from: C, reason: from kotlin metadata */
        private boolean isUseTokenType;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private List<GuildHotSearchItem> data;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean centerAlign;

        public b(boolean z16, boolean z17) {
            List<GuildHotSearchItem> emptyList;
            this.centerAlign = z16;
            this.isUseTokenType = z17;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.data = emptyList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            int coerceAtLeast;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.data.size(), 1);
            return coerceAtLeast;
        }

        @NotNull
        public final String j0(int position) {
            if (position >= this.data.size()) {
                String DEFAULT_TIPS = a.f26080g;
                Intrinsics.checkNotNullExpressionValue(DEFAULT_TIPS, "DEFAULT_TIPS");
                return DEFAULT_TIPS;
            }
            return this.data.get(position).getText();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            String format;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (position >= this.data.size()) {
                format = a.f26080g;
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String qqStr = HardCodeUtil.qqStr(R.string.f155481hm);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_search_hot_word)");
                format = String.format(qqStr, Arrays.copyOf(new Object[]{this.data.get(position).getText()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            holder.getBinding().f442255b.setText(format);
            if (this.isUseTokenType) {
                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                TextView textView = holder.getBinding().f442255b;
                Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.hotSearchWord");
                guildUIUtils.b(textView, R.color.qui_common_text_secondary_light);
                ImageView imageView = holder.getBinding().f442256c;
                Intrinsics.checkNotNullExpressionValue(imageView, "holder.binding.searchIcon");
                GuildUIUtils.d(imageView, R.drawable.guild_searchbar_icon, Integer.valueOf(R.color.qui_common_text_secondary_light));
            } else {
                GuildUIUtils guildUIUtils2 = GuildUIUtils.f235378a;
                TextView textView2 = holder.getBinding().f442255b;
                Intrinsics.checkNotNullExpressionValue(textView2, "holder.binding.hotSearchWord");
                guildUIUtils2.b(textView2, R.color.guild_skin_form_text_gray);
                ImageView imageView2 = holder.getBinding().f442256c;
                Intrinsics.checkNotNullExpressionValue(imageView2, "holder.binding.searchIcon");
                GuildUIUtils.e(imageView2, R.drawable.guild_searchbar_icon, null, 2, null);
            }
            ViewCompat.setImportantForAccessibility(holder.getBinding().getRoot(), 2);
            ViewCompat.setImportantForAccessibility(holder.getBinding().f442255b, 2);
        }

        @Override // com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher.d
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public d i0(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            am g16 = am.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            if (this.centerAlign) {
                g16.f442257d.setGravity(17);
            } else {
                g16.f442257d.setGravity(16);
            }
            return new d(g16);
        }

        public final void m0(boolean z16) {
            this.centerAlign = z16;
        }

        public final void n0(boolean z16) {
            this.isUseTokenType = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lah1/a$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lvp1/am;", "E", "Lvp1/am;", "l", "()Lvp1/am;", "binding", "<init>", "(Lvp1/am;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final am binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull am binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final am getBinding() {
            return this.binding;
        }
    }

    public a(@NotNull ViewGroup rootView, boolean z16) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.isUseTokenType = z16;
        View findViewById = rootView.findViewById(R.id.wzq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026uild_search_tip_hot_word)");
        this.mSearchTips = findViewById;
        View findViewById2 = rootView.findViewById(R.id.wzq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026uild_search_tip_hot_word)");
        this.mHotSearchTips = (DownToUpViewSwitcher) findViewById2;
        String DEFAULT_TIPS = f26080g;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_TIPS, "DEFAULT_TIPS");
        this.mCurSelectTips = DEFAULT_TIPS;
        b bVar = new b(false, this.isUseTokenType);
        this.adapter = bVar;
        this.mHotSearchTips.q(new C0036a());
        this.mHotSearchTips.setAdapter(bVar);
    }

    private final void j() {
        this.mHotSearchTips.setAutoScroll(false);
    }

    private final void m() {
        this.mHotSearchTips.setAutoScroll(true);
    }

    @NotNull
    public final String f() {
        if (TextUtils.equals(this.mCurSelectTips, f26080g)) {
            return "";
        }
        return this.mCurSelectTips;
    }

    public final void g() {
        QLog.d("Guild.search.GuildDisSearch-HotSearchAnimController", 1, "[onHide] ");
        j();
    }

    public final void h() {
        QLog.d("Guild.search.GuildDisSearch-HotSearchAnimController", 1, "[onShow] visible = " + this.mSearchTips.getVisibility());
        m();
    }

    public final void i() {
        this.adapter.notifyDataSetChanged();
    }

    public final void k() {
        this.adapter.m0(true);
    }

    public final void l(boolean isUseTokenType) {
        if (this.isUseTokenType != isUseTokenType) {
            this.isUseTokenType = isUseTokenType;
            this.adapter.n0(isUseTokenType);
            this.adapter.notifyDataSetChanged();
        }
    }

    public final void n() {
        DownToUpViewSwitcher.v(this.mHotSearchTips, false, 1, null);
    }
}
