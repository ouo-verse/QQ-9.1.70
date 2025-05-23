package com.tencent.mobileqq.guild.mainframe.create;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.EdgeTransparentView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.inputview.CharacterCountEditText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import com.tencent.util.InputMethodUtil;
import h53.k;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\n\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u001e\u0010\f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010%\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010-\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001cR\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/GuildNameInputView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lcom/tencent/mobileqq/guild/widget/EdgeTransparentView;", "", "show", "", "position", "o", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "k", "initName", "l", "onThemeChanged", "Landroid/view/View;", "d", "Landroid/view/View;", "inputContainer", "e", "uneditedLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "guildNameTextView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "editIcon", "i", "editedLayout", "Lcom/tencent/mobileqq/guild/widget/EdgeTransparentView;", "edgeContainer", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "guildNameInputView", "D", "clearIcon", "E", "wordCount", UserInfo.SEX_FEMALE, "Z", "hasInputText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNameInputView extends LinearLayout implements SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private CharacterCountEditText guildNameInputView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ImageView clearIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView wordCount;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasInputText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View inputContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View uneditedLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView guildNameTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView editIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View editedLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EdgeTransparentView edgeContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f227359d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildNameInputView f227360e;

        public b(View view, GuildNameInputView guildNameInputView) {
            this.f227359d = view;
            this.f227360e = guildNameInputView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f227360e.guildNameInputView.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f227361d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildNameInputView f227362e;

        public c(View view, GuildNameInputView guildNameInputView) {
            this.f227361d = view;
            this.f227362e = guildNameInputView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f227362e.uneditedLayout.setVisibility(8);
                this.f227362e.editedLayout.setVisibility(0);
                this.f227362e.wordCount.setVisibility(0);
                this.f227362e.guildNameInputView.requestFocus();
                InputMethodUtil.show(this.f227362e.guildNameInputView);
                this.f227362e.guildNameInputView.setSelection(this.f227362e.guildNameInputView.getText().length());
                bt.h(bt.f235484a, this.f227362e.uneditedLayout, "em_sgrp_create_name", "clck", null, 8, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/GuildNameInputView$e", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText$b;", "", "l", "t", "oldl", "oldt", "", "onScrollChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements CharacterCountEditText.b {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.inputview.CharacterCountEditText.b
        public void onScrollChanged(int l3, int t16, int oldl, int oldt) {
            GuildNameInputView.this.j();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNameInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (!this.guildNameInputView.canScrollHorizontally(-1) && !this.guildNameInputView.canScrollHorizontally(1)) {
            p(this, this.edgeContainer, false, 0, 2, null);
            return;
        }
        int i3 = 0;
        if (this.guildNameInputView.canScrollHorizontally(-1)) {
            i3 = 0 | EdgeTransparentView.I;
        }
        if (this.guildNameInputView.canScrollHorizontally(1)) {
            i3 |= EdgeTransparentView.J;
        }
        o(this.edgeContainer, true, i3);
    }

    private final void m() {
        s.a(this.guildNameTextView, 500, 0);
        s.a(this.guildNameInputView, 500, 0);
        this.guildNameInputView.setLimitCount(16);
        this.guildNameInputView.setInputViewWatcher(new d());
        this.guildNameInputView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.guild.mainframe.create.n
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                GuildNameInputView.n(GuildNameInputView.this, view, z16);
            }
        });
        this.guildNameInputView.setScrollChangedListener(new e());
        ImageView imageView = this.clearIcon;
        imageView.setOnClickListener(new b(imageView, this));
        View view = this.uneditedLayout;
        view.setOnClickListener(new c(view, this));
        GuildUIUtils.d(this.clearIcon, R.drawable.qui_close_filled, Integer.valueOf(R.color.qui_common_icon_secondary));
        GuildUIUtils.d(this.editIcon, R.drawable.guild_create_edit, Integer.valueOf(R.color.qui_common_text_secondary_light));
        s();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildNameInputView this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildNameInputView", 2, "focusChange: " + z16);
        }
        if (!z16) {
            this$0.uneditedLayout.setVisibility(0);
            this$0.editedLayout.setVisibility(8);
            this$0.guildNameTextView.setText(this$0.guildNameInputView.getText());
            this$0.wordCount.setVisibility(4);
        }
        this$0.s();
    }

    private final void o(EdgeTransparentView edgeTransparentView, boolean z16, int i3) {
        int i16;
        if (z16) {
            edgeTransparentView.setEdgePosition(i3);
        }
        if (z16) {
            i16 = QQGuildUIUtil.f(12.0f);
        } else {
            i16 = 0;
        }
        edgeTransparentView.setEdgeWidth(i16);
    }

    static /* synthetic */ void p(GuildNameInputView guildNameInputView, EdgeTransparentView edgeTransparentView, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        guildNameInputView.o(edgeTransparentView, z16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (this.guildNameInputView.getCurrentCount() > 0) {
            this.clearIcon.setVisibility(0);
        } else {
            this.clearIcon.setVisibility(4);
        }
    }

    private final void r() {
        View view = this.inputContainer;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.b(36));
        gradientDrawable.setStroke(bi.a(0.5f), getContext().getResources().getColor(R.color.qui_button_border_ghost_default));
        view.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        int i3;
        int currentCount = this.guildNameInputView.getCurrentCount();
        boolean z16 = false;
        if (1 <= currentCount && currentCount < 16) {
            z16 = true;
        }
        if (z16) {
            i3 = R.color.qui_common_text_tertiary;
        } else {
            i3 = R.color.qui_common_feedback_error;
        }
        GuildUIUtils.f235378a.b(this.wordCount, i3);
        this.wordCount.setText(this.guildNameInputView.getCurrentCount() + "/16");
    }

    @NotNull
    public final String k() {
        return this.guildNameInputView.getText().toString();
    }

    public final void l(@NotNull String initName) {
        Intrinsics.checkNotNullParameter(initName, "initName");
        if (!this.hasInputText) {
            this.guildNameTextView.setText(initName);
            this.guildNameInputView.setText(initName);
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        r();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNameInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildNameInputView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNameInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.f0v, this);
        setOrientation(1);
        View findViewById = findViewById(R.id.dmo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.input_container)");
        this.inputContainer = findViewById;
        View findViewById2 = findViewById(R.id.f114016s7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.unedited_layout)");
        this.uneditedLayout = findViewById2;
        View findViewById3 = findViewById(R.id.f165582ws2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_name_text_view)");
        this.guildNameTextView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.uqd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.edit_icon)");
        this.editIcon = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f165056ur2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.edited_layout)");
        this.editedLayout = findViewById5;
        View findViewById6 = findViewById(R.id.upi);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.edge_transparent_container)");
        this.edgeContainer = (EdgeTransparentView) findViewById6;
        View findViewById7 = findViewById(R.id.wrw);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.guild_name)");
        this.guildNameInputView = (CharacterCountEditText) findViewById7;
        View findViewById8 = findViewById(R.id.ayh);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.clear_icon)");
        this.clearIcon = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.f124977kt);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.word_count)");
        this.wordCount = (TextView) findViewById9;
        m();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/GuildNameInputView$d", "Lh53/k;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements h53.k {
        d() {
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            GuildNameInputView.this.s();
            GuildNameInputView.this.q();
            GuildNameInputView.this.j();
        }

        @Override // h53.k
        public void f8(boolean z16) {
            k.a.a(this, z16);
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            GuildNameInputView.this.hasInputText = true;
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
