package com.tencent.mobileqq.troop.troopidentity.view.alltags;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102JZ\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042B\b\u0002\u0010\u000f\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006j\u0004\u0018\u0001`\u000eJ&\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'RP\u0010*\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006j\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/InteractiveTagGroupView;", "Landroid/widget/LinearLayout;", "", "troopUin", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "reporter", "Lkotlin/Function2;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "Lkotlin/ParameterName;", "name", "iconInfo", "", "isSelected", "", "Lcom/tencent/mobileqq/troop/troopidentity/view/TroopIdentityInteractiveIconClickCallback;", "cb", "a", "title", "desc", "", "data", "b", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleView", "e", "descView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "tagsGroupRecyclerView", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/a;", h.F, "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/a;", "adapter", "i", "vipEntranceTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "callback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class InteractiveTagGroupView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function2<? super GroupIdentityInteractionTag, ? super Boolean, Unit> callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView descView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView tagsGroupRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView vipEntranceTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/InteractiveTagGroupView$a;", "", "", "INTERACTIVE_VIP_URL", "Ljava/lang/String;", "", "MAX_COLUMN_SIZE", "I", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.view.alltags.InteractiveTagGroupView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveTagGroupView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    public final void a(@NotNull String troopUin, @NotNull com.tencent.mobileqq.troop.troopidentity.util.a reporter, @Nullable Function2<? super GroupIdentityInteractionTag, ? super Boolean, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, reporter, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.troopUin = troopUin;
        this.callback = cb5;
        this.tagsGroupRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a aVar = new a(context, troopUin, reporter, cb5);
        this.adapter = aVar;
        this.tagsGroupRecyclerView.setAdapter(aVar);
    }

    public final void b(@NotNull String title, @NotNull String desc, @Nullable List<GroupIdentityInteractionTag> data) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, title, desc, data);
            return;
        }
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (data != null) {
            num = Integer.valueOf(data.size());
        } else {
            num = null;
        }
        boolean z16 = true;
        QLog.i("InteractiveTagGroupView", 1, "[submit] title:" + title + ", data:" + num);
        List<GroupIdentityInteractionTag> list = data;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.titleView.setText(title);
        this.descView.setText(desc);
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.n0(data);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveTagGroupView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ InteractiveTagGroupView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveTagGroupView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.troopUin = "";
        View inflate = View.inflate(context, R.layout.g0n, this);
        View findViewById = inflate.findViewById(R.id.xpg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.interactive_group_title)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.xpe);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.interactive_group_desc)");
        this.descView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.xpf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_group_item_recyclerview)");
        this.tagsGroupRecyclerView = (RecyclerView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.xpm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026interactive_vip_entrance)");
        this.vipEntranceTv = (TextView) findViewById4;
    }
}
