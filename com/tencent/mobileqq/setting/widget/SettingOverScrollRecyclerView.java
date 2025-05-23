package com.tencent.mobileqq.setting.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.m;
import com.tencent.mobileqq.widget.listitem.o;
import com.tencent.mobileqq.widget.listitem.p;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0003-./B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0019\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "Lcom/tencent/theme/SkinnableView;", "", "has", "", "setHasTopSpace", "setHasBottomSpace", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$DividerStyle;", "style", "setDividerStyle", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "O", "onThemeChanged", "Lcom/tencent/mobileqq/widget/listitem/m;", "D", "Lcom/tencent/mobileqq/widget/listitem/m;", "dividerDecoration", "Lcom/tencent/mobileqq/widget/listitem/p;", "E", "Lcom/tencent/mobileqq/widget/listitem/p;", "groupSpaceDecoration", "", UserInfo.SEX_FEMALE, "I", "verticalScrollOffset", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;", "G", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;", "P", "()Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;", "setOnVerticalScrollListener", "(Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;)V", "onVerticalScrollListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "c", "DividerStyle", "d", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SettingOverScrollRecyclerView extends OverScrollRecyclerView implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private m dividerDecoration;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final p groupSpaceDecoration;

    /* renamed from: F, reason: from kotlin metadata */
    private int verticalScrollOffset;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private d onVerticalScrollListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$DividerStyle;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "Middle", "Hidden", "ShowAll", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class DividerStyle {
        private static final /* synthetic */ DividerStyle[] $VALUES;
        static IPatchRedirector $redirector_;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final DividerStyle Hidden;
        public static final DividerStyle Middle;
        public static final DividerStyle ShowAll;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$DividerStyle$a;", "", "<init>", "()V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView$DividerStyle$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ DividerStyle[] $values() {
            return new DividerStyle[]{Middle, Hidden, ShowAll};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35236);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            Middle = new DividerStyle("Middle", 0, 0);
            Hidden = new DividerStyle("Hidden", 1, 1);
            ShowAll = new DividerStyle("ShowAll", 2, 2);
            $VALUES = $values();
            INSTANCE = new Companion(null);
        }

        DividerStyle(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static DividerStyle valueOf(String str) {
            return (DividerStyle) Enum.valueOf(DividerStyle.class, str);
        }

        public static DividerStyle[] values() {
            return (DividerStyle[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$a", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView$OnOverScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "overScrollX", "overScrollY", "", "a", "state", "b", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements OverScrollRecyclerView.OnOverScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingOverScrollRecyclerView.this);
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.OnOverScrollListener
        public void a(@Nullable RecyclerView recyclerView, int overScrollX, int overScrollY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(overScrollX), Integer.valueOf(overScrollY));
                return;
            }
            int i3 = SettingOverScrollRecyclerView.this.verticalScrollOffset - overScrollY;
            d P = SettingOverScrollRecyclerView.this.P();
            if (P != null) {
                P.onVerticalScroll(i3);
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.OnOverScrollListener
        public void b(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, state);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingOverScrollRecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            SettingOverScrollRecyclerView.this.verticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int G = SettingOverScrollRecyclerView.this.verticalScrollOffset - SettingOverScrollRecyclerView.this.G();
            d P = SettingOverScrollRecyclerView.this.P();
            if (P != null) {
                P.onVerticalScroll(G);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$c;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView$c, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;", "", "", "offsetY", "", "onVerticalScroll", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface d {
        void onVerticalScroll(int offsetY);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f286776a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35239);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[DividerStyle.values().length];
            try {
                iArr[DividerStyle.Middle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DividerStyle.ShowAll.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DividerStyle.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f286776a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingOverScrollRecyclerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @Nullable
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public QUIListItemAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (QUIListItemAdapter) super.getAdapter();
    }

    @Nullable
    public final d P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.onVerticalScrollListener;
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        setItemViewCacheSize(Integer.MIN_VALUE);
        getRecycledViewPool().clear();
        m mVar = this.dividerDecoration;
        if (mVar != null) {
            mVar.d(1000);
        }
        K();
        QLog.d("SettingOverScrollRecyclerView", 1, "[SettingOverScrollRecyclerView.onThemeChanged]");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) adapter);
            return;
        }
        if (adapter == null) {
            z16 = true;
        } else {
            z16 = adapter instanceof QUIListItemAdapter;
        }
        if (z16) {
            super.setAdapter(adapter);
            return;
        }
        throw new IllegalStateException("\u53ea\u80fd\u8bbe\u7f6eQUIListItemAdapter\u7c7b\u578b\u7684Adapter");
    }

    public final void setDividerStyle(@NotNull DividerStyle style) {
        RecyclerView.ItemDecoration itemDecoration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) style);
            return;
        }
        Intrinsics.checkNotNullParameter(style, "style");
        int i3 = e.f286776a[style.ordinal()];
        boolean z16 = true;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 && (itemDecoration = this.dividerDecoration) != null) {
                this.dividerDecoration = null;
                removeItemDecoration(itemDecoration);
                return;
            }
            return;
        }
        if (style != DividerStyle.ShowAll) {
            z16 = false;
        }
        m mVar = this.dividerDecoration;
        if (mVar != null) {
            if (mVar.getShowBottomDivider() != z16) {
                mVar.c(z16);
                requestLayout();
                return;
            }
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        m mVar2 = new m(context, z16);
        addItemDecoration(mVar2);
        this.dividerDecoration = mVar2;
    }

    public final void setHasBottomSpace(boolean has) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, has);
        } else {
            this.groupSpaceDecoration.a(has);
            requestLayout();
        }
    }

    public final void setHasTopSpace(boolean has) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, has);
        } else {
            this.groupSpaceDecoration.b(has);
            requestLayout();
        }
    }

    public final void setOnVerticalScrollListener(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        } else {
            this.onVerticalScrollListener = dVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingOverScrollRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ SettingOverScrollRecyclerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingOverScrollRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        if (getLayoutManager() == null) {
            setLayoutManager(new LinearLayoutManager(context, 1, false));
        }
        setItemAnimator(null);
        setDividerStyle(DividerStyle.Middle);
        p pVar = new p(context, true, true);
        addItemDecoration(pVar);
        this.groupSpaceDecoration = pVar;
        addItemDecoration(new o());
        setTouchDragRatio(1.8f, 1.8f);
        F(new a());
        addOnScrollListener(new b());
    }
}
