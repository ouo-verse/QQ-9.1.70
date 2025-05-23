package com.tencent.mobileqq.troop.teamup.home.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.teamup.home.data.TroopTeamUpData;
import com.tencent.mobileqq.troop.teamup.home.view.MediaDisplayView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ;2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u00108\u001a\u00020.\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0017\u0010%\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u0017\u0010(\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u0017\u0010-\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001f\u00104\u001a\n /*\u0004\u0018\u00010.0.8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/TroopTeamUpContentListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;", "view", "", "w", "Landroid/content/Context;", "context", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData;", "data", "o", "r", ReportConstant.COSTREPORT_PREFIX, "p", "Landroid/view/View$OnClickListener;", "clickEvent", "y", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getApplyButtonText", "()Landroid/widget/TextView;", "applyButtonText", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getApplyButtonImage", "()Landroid/widget/ImageView;", "applyButtonImage", "G", "getStateTagText", "stateTagText", "H", "getStateTagImage", "stateTagImage", "I", "getTitle", "title", "J", "Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;", "u", "()Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;", "content", "Landroid/view/View;", "kotlin.jvm.PlatformType", "K", "Landroid/view/View;", "v", "()Landroid/view/View;", "titleArea", "L", "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData;", "currentData", "itemView", "<init>", "(Landroid/view/View;)V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpContentListItemViewHolder extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int N;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView applyButtonText;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView applyButtonImage;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView stateTagText;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ImageView stateTagImage;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MediaDisplayView content;

    /* renamed from: K, reason: from kotlin metadata */
    private final View titleArea;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TroopTeamUpData currentData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/TroopTeamUpContentListItemViewHolder$a;", "", "", "MIN_GAP_FOR_TITLE_MAX_WIDTH", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.adapter.TroopTeamUpContentListItemViewHolder$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298956a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55778);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TroopTeamUpData.TroopTeamUpState.values().length];
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.CAN_APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.CAN_APPLY_WITH_IMG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.ALREADY_APPLIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.ALREADY_UPLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TroopTeamUpData.TroopTeamUpState.INVALID.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f298956a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55784);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
            N = com.tencent.biz.qui.quicommon.e.a(16.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpContentListItemViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.f93565_x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026eam_up_apply_button_text)");
        this.applyButtonText = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f93555_w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026eam_up_apply_button_icon)");
        this.applyButtonImage = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f93805ak);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.team_up_state_tag_text)");
        this.stateTagText = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.f93795aj);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.team_up_state_tag_icon)");
        this.stateTagImage = (ImageView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.f93815al);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.team_up_title)");
        this.title = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.f93575_y);
        MediaDisplayView it = (MediaDisplayView) findViewById6;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        w(it);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById<Me\u2026{ initFoldMediaView(it) }");
        this.content = it;
        this.titleArea = itemView.findViewById(R.id.jo7);
    }

    private final void A(Context context) {
        this.applyButtonText.setText(context.getString(R.string.f235947d1));
        this.applyButtonText.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.qui_common_text_tertiary, context.getTheme()));
        this.applyButtonImage.setVisibility(8);
    }

    private final void o(TroopTeamUpData data) {
        Context context = this.itemView.getContext();
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        switch (b.f298956a[data.i().ordinal()]) {
            case 1:
                if (data.k()) {
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    A(context);
                    return;
                } else {
                    this.applyButtonText.setText(context.getString(R.string.f235787cl));
                    this.applyButtonText.setTextColor(ResourcesCompat.getColor(resources, R.color.qui_common_brand_standard, theme));
                    this.applyButtonImage.setVisibility(0);
                    this.applyButtonImage.setImageResource(R.drawable.qui_chevron_right_brand_standard);
                    return;
                }
            case 2:
                if (data.k()) {
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    A(context);
                    return;
                } else {
                    this.applyButtonText.setText(context.getString(R.string.f235797cm));
                    this.applyButtonText.setTextColor(ResourcesCompat.getColor(resources, R.color.qui_common_brand_standard, theme));
                    this.applyButtonImage.setVisibility(0);
                    this.applyButtonImage.setImageResource(R.drawable.qui_chevron_right_brand_standard);
                    return;
                }
            case 3:
                this.applyButtonText.setText(context.getString(R.string.f235757ci, Integer.valueOf(data.c()), Integer.valueOf(data.g())));
                this.applyButtonText.setTextColor(ResourcesCompat.getColor(resources, R.color.qui_common_text_secondary, theme));
                this.applyButtonImage.setVisibility(0);
                this.applyButtonImage.setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
                return;
            case 4:
                this.applyButtonText.setText(context.getString(R.string.f235767cj, Integer.valueOf(data.c()), Integer.valueOf(data.g())));
                this.applyButtonText.setTextColor(ResourcesCompat.getColor(resources, R.color.qui_common_text_secondary, theme));
                this.applyButtonImage.setVisibility(0);
                this.applyButtonImage.setImageResource(R.drawable.qui_chevron_right_icon_secondary);
                return;
            case 5:
                this.applyButtonText.setText(context.getString(R.string.f236497ei));
                this.applyButtonText.setTextColor(ResourcesCompat.getColor(resources, R.color.qui_common_text_tertiary, theme));
                this.applyButtonImage.setVisibility(8);
                return;
            case 6:
                QLog.w("TroopTeamUpTroopTeamUpContentListItemViewHolder", 1, "TroopTeamUpState is INVALID");
                this.applyButtonText.setText("");
                this.applyButtonImage.setVisibility(8);
                return;
            default:
                return;
        }
    }

    private final void p(TroopTeamUpData data) {
        this.content.f().j(data.d());
        if (data.h()) {
            this.content.a(!data.d().b().isEmpty());
        } else {
            this.content.b();
        }
    }

    private final void r(TroopTeamUpData data) {
        boolean z16;
        int i3 = 0;
        if (data.i().isActive() && !data.k()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        this.stateTagImage.setVisibility(i3);
        this.stateTagText.setVisibility(i3);
    }

    private final void s(TroopTeamUpData data) {
        this.title.setText(data.j());
        this.title.post(new Runnable() { // from class: com.tencent.mobileqq.troop.teamup.home.adapter.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopTeamUpContentListItemViewHolder.t(TroopTeamUpContentListItemViewHolder.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(TroopTeamUpContentListItemViewHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.title.setMaxWidth(((((this$0.titleArea.getWidth() - this$0.stateTagImage.getWidth()) - this$0.stateTagText.getWidth()) - this$0.applyButtonText.getWidth()) - this$0.applyButtonImage.getWidth()) - N);
    }

    private final void w(MediaDisplayView view) {
        view.setOnClickExpand(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.teamup.home.adapter.TroopTeamUpContentListItemViewHolder$initFoldMediaView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListItemViewHolder.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TroopTeamUpData troopTeamUpData;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                troopTeamUpData = TroopTeamUpContentListItemViewHolder.this.currentData;
                if (troopTeamUpData == null) {
                    return;
                }
                troopTeamUpData.m(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(TroopTeamUpContentListItemViewHolder this$0, View.OnClickListener clickEvent, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickEvent, "$clickEvent");
        TroopTeamUpData troopTeamUpData = this$0.currentData;
        if (troopTeamUpData != null) {
            str = troopTeamUpData.f();
        } else {
            str = null;
        }
        QLog.d("TroopTeamUpTroopTeamUpContentListItemViewHolder", 1, "onContentClick:" + str);
        clickEvent.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void q(@NotNull TroopTeamUpData data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentData = data;
        o(data);
        r(data);
        s(data);
        p(data);
    }

    @NotNull
    public final MediaDisplayView u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediaDisplayView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.content;
    }

    public final View v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.titleArea;
    }

    public final void x(@NotNull View.OnClickListener clickEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) clickEvent);
        } else {
            Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
            this.content.setOnClickListener(clickEvent);
        }
    }

    public final void y(@NotNull final View.OnClickListener clickEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) clickEvent);
        } else {
            Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
            this.titleArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.home.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopTeamUpContentListItemViewHolder.z(TroopTeamUpContentListItemViewHolder.this, clickEvent, view);
                }
            });
        }
    }
}
